package com.ilex.codingchallenge.user.entity;

/**
 * @author Vincent Geng
 *
 * Created on Dec 18, 2020
 */
public class User {
	private Long userId;
	private String userName;
	
	public User() {
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
