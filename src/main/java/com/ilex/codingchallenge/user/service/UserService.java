package com.ilex.codingchallenge.user.service;

import java.util.Optional;

import com.ilex.codingchallenge.user.entity.User;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public interface UserService {

	/**
	 * @param userId
	 * @return
	 */
	Optional<User> findById(Long userId);

}
