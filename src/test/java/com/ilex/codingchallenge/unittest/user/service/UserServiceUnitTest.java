package com.ilex.codingchallenge.unittest.user.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ilex.codingchallenge.unittest.utils.UserTestUtils;
import com.ilex.codingchallenge.user.entity.User;
import com.ilex.codingchallenge.user.repository.UserRepository;
import com.ilex.codingchallenge.user.service.UserService;
import com.ilex.codingchallenge.user.service.UserServiceImpl;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
@DisplayName("Product Service Unit Test")
@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {
	
	@InjectMocks
    private UserService userService = new UserServiceImpl();
	
	@Mock
	private UserRepository userRepository;
	
	@Test
    @DisplayName("Test findById Success")
	public void testFindById() throws Exception {
		when(userRepository.findById(anyLong())).thenReturn(Optional.of(UserTestUtils.mockUser()));
		Optional<User> user = userService.findById(1l);
		
		Assertions.assertTrue(user.isPresent(), "User was not found.");
		Assertions.assertSame(user.get().getUserId(), 1l);
		Assertions.assertSame(user.get().getUserName(), "User 1");
	}
	
	@Test
    @DisplayName("Test save Success")
	public void testSave() throws Exception {
		when(userRepository.save(any(User.class))).thenReturn(UserTestUtils.mockUser());
		User user = userService.save(UserTestUtils.mockUserDTO());
		
		Assertions.assertSame(user.getUserId(), 1l);
		Assertions.assertSame(user.getUserName(), "User 1");
	}
	
}
