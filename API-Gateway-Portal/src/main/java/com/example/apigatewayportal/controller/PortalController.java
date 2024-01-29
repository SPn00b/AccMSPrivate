package com.example.apigatewayportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apigatewayportal.model.Portal;
import com.example.apigatewayportal.repository.PortalRepository;

@RestController
@RequestMapping("/portal")
public class PortalController {

	private PortalRepository portalRepository;

	@Autowired
	private PortalController(PortalRepository portalRepository) {
		this.portalRepository = portalRepository;
	}

	@GetMapping
	List<Portal> getAllPortals() {
		return portalRepository.findAll();
	}

	@GetMapping("/{id}")
	Portal getPortalById(@RequestParam long portalId) throws Exception {
		Optional<Portal> optionalPortal = portalRepository.findById(portalId);
		if (optionalPortal.isPresent()) {
			return optionalPortal.get();
		}
		throw new Exception("optional Portal is not present!");
	}

}
