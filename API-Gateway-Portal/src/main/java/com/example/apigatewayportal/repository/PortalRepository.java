package com.example.apigatewayportal.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.apigatewayportal.model.Portal;

//public interface PortalRepository extends ListCrudRepository<Portal, Long> {
//
//}
public class PortalRepository {
	private List<Portal> poList = new ArrayList<>();

	public Portal add(Portal portal) {
		portal.setPortalId(poList.size() + 1);
		poList.add(portal);
		return portal;
	}

	public List<Portal> findAll() {
		return poList;
	}

	public Optional<Portal> findById(long portalId) {
		return poList.stream().filter(p -> p.getPortalId() == portalId)
				.findFirst();
	}
}
