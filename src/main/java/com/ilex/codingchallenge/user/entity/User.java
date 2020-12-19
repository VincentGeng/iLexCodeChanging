package com.ilex.codingchallenge.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vincent Geng
 *
 * Created on Dec 18, 2020
 */
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", columnDefinition = "int(11)", nullable = false)
	private Long userId;
	
	@Column(name = "user_name", columnDefinition = "varchar(100)", nullable = false)
	private String userName;
	
	public User() {
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
