package com.ilex.codingchallenge.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ilex.codingchallenge.user.dto.UserDTO;
import com.ilex.codingchallenge.user.entity.User;
import com.ilex.codingchallenge.user.service.UserService;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// Add User
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users")
    public User addNewUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }
}
