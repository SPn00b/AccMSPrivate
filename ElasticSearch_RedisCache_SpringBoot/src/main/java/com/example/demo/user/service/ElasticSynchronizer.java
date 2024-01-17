package com.example.demo.user.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Constants;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserMapper;
import com.example.demo.user.repo.UserESRepo;
import com.example.demo.user.repo.UserRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Root;

@Service
public class ElasticSynchronizer {

	static org.slf4j.Logger log = LoggerFactory
			.getLogger(ElasticSynchronizer.class.getName());

	private UserMapper userMapper;
	private UserRepo userRepository;
	private UserESRepo userIndexRepository;

	@Autowired
	public ElasticSynchronizer(UserMapper userMapper, UserRepo userRepository,
			UserESRepo userIndexRepository) {
		this.userMapper = userMapper;
		this.userRepository = userRepository;
		this.userIndexRepository = userIndexRepository;
	}

	private Date lastSyncDate = new Date(0);

	@Scheduled(cron = "0 */3 * * * *")
	@Transactional
	public void sync() {
		log.info("Start Syncing - {}", LocalDateTime.now());
		this.syncUsers();
		log.info(" End Syncing - {}", LocalDateTime.now());
	}

	public void syncUsers() {
		Specification<User> userSpecification = (root, criteriaQuery,
				criteriaBuilder) -> getModificationDatePredicate(
						criteriaBuilder, root);
		List<User> userList;
		if (UserESRepo.count() == 0) {
			userList = userDAO.findAll();
		} else {
			userList = userDAO.findAll(userSpecification);
		}
		for (User user : userList) {
			log.info("Syncing User - {}", user.getId());
			UserESRepo.save(this.userMapper.toUserModel(user));
		}
	}

	private static Predicate getModificationDatePredicate(CriteriaBuilder cb,
			Root<?> root) {
		Expression<Timestamp> currentTime;
		currentTime = cb.currentTimestamp();
		Expression<Timestamp> currentTimeMinus = cb
				.literal(new Timestamp(System.currentTimeMillis()
						- Constants.INTERVAL_IN_MILLISECONDE));
		return cb.between(root.<Date>get(Constants.MODIFICATION_DATE),
				currentTimeMinus, currentTime);
	}

}
