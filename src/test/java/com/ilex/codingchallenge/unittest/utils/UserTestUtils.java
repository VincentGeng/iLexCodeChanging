package com.ilex.codingchallenge.unittest.utils;

import com.ilex.codingchallenge.user.entity.User;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public class UserTestUtils {
	public static User mockUser(){
		User user = new User();
		user.setUserId(1l);
		user.setUserName("User 1");
		return user;
	}
}
