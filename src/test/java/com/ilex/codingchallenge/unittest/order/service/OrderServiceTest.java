package com.ilex.codingchallenge.unittest.order.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ilex.codingchallenge.order.entity.Order;
import com.ilex.codingchallenge.order.repository.OrderRepository;
import com.ilex.codingchallenge.order.service.OrderService;
import com.ilex.codingchallenge.order.service.OrderServiceImpl;
import com.ilex.codingchallenge.product.service.ProductService;
import com.ilex.codingchallenge.unittest.utils.OrderTestUtils;
import com.ilex.codingchallenge.user.service.UserService;

/**
 * @author Vincent Geng
 *
 * Created on Dec 20, 2020
 */
@DisplayName("Order Service Unit Test")
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
	
	@InjectMocks
    private OrderService orderService = new OrderServiceImpl();
	
	@Mock
	private OrderRepository orderRepository;
	
	@Mock
	private ProductService productService;
	
	@Mock
	private UserService userService;
	
	@Test
    @DisplayName("Test findByUserUserIdAndCreationDateBetween Success")
	public void testFindByUserUserIdAndCreationDateBetween() throws Exception {
		when(orderRepository.findByUserUserIdAndCreationDateBetween(anyLong(), any(Date.class), any(Date.class))).thenReturn(Arrays.asList(OrderTestUtils.mockOrder()));
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String fromDateStr = "20/12/2020";
		Date fromDate = formatter.parse(fromDateStr);
		String toDateStr = "21/12/2020";
		Date toDate = formatter.parse(toDateStr);
		List<Order> orders = orderService.findByUserUserIdAndCreationDateBetween(1l, fromDate, toDate);
		
		Assertions.assertSame(orders.size(), 1);
	}
	
	@Test
    @DisplayName("Test placeOrders Success")
	public void testPlaceOrders() throws Exception {
		
	}

}
