package com.ilex.codingchallenge.unittest.utils;

import com.ilex.codingchallenge.user.dto.UserDTO;
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
	
	public static UserDTO mockUserDTO(){
		UserDTO user = new UserDTO();
		user.setUserName("User 1");
		return user;
	}
}
