package com.pbrm.backend.model;

/**
 * Patrick Rodriguez 2021/02/10
 */

public class User {

	private String user;
	private String password;
	private String name;

	public User(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	
	public User() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
