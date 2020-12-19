package com.ilex.codingchallenge.unittest.user.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ilex.codingchallenge.unittest.utils.UserTestUtils;
import com.ilex.codingchallenge.user.entity.User;
import com.ilex.codingchallenge.user.repository.UserRepository;
import com.ilex.codingchallenge.user.service.UserService;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
@SpringBootTest
public class UserServiceUnitTest {
	
	@Autowired
    private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
    @DisplayName("Test findById Success")
	public void testFindById() throws Exception {
		when(userRepository.findById(anyLong())).thenReturn(Optional.of(UserTestUtils.mockUser()));
		Optional<User> user = userService.findById(1l);
		
		Assertions.assertTrue(user.isPresent(), "User was not found.");
		Assertions.assertSame(user.get().getUserId(), "1l");
		Assertions.assertSame(user.get().getUserName(), "User 1");
	}
	
	@Test
    @DisplayName("Test save Success")
	public void testSave() throws Exception {
		when(userRepository.save(any(User.class))).thenReturn(UserTestUtils.mockUser());
		User user = userService.save(UserTestUtils.mockUserDTO());
		
		Assertions.assertSame(user.getUserId(), "1l");
		Assertions.assertSame(user.getUserName(), "User 1");
	}
	
}
