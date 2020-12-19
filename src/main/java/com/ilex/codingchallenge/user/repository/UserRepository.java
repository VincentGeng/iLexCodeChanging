package com.ilex.codingchallenge.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.ilex.codingchallenge.user.entity.User;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
