package com.example.apigatewayportal.model;

import java.util.List;

public class Portal {
	private long portalId;
	private List<User> users;

	public Portal(long portalId, List<User> users) {
		super();
		this.portalId = portalId;
		this.users = users;
	}
	public long getPortalId() {
		return portalId;
	}
	public void setPortalId(long portalId) {
		this.portalId = portalId;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
