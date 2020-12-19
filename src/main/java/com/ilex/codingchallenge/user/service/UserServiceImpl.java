package com.ilex.codingchallenge.user.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ilex.codingchallenge.user.dto.UserDTO;
import com.ilex.codingchallenge.user.entity.User;
import com.ilex.codingchallenge.user.repository.UserRepository;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	/* (non-Javadoc)
	 * @see com.ilex.codingchallenge.user.service.UserService#findById(java.lang.Long)
	 */
	@Override
	public Optional<User> findById(Long userId) {
		return userRepository.findById(userId);
	}

	/* (non-Javadoc)
	 * @see com.ilex.codingchallenge.user.service.UserService#save(com.ilex.codingchallenge.user.dto.UserDTO)
	 */
	@Override
	public User save(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		return userRepository.save(user);
	}

}
