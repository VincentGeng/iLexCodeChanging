package com.ilex.codingchallenge.unittest.order.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilex.codingchallenge.order.controller.OrderController;
import com.ilex.codingchallenge.order.dto.OrderDTO;
import com.ilex.codingchallenge.order.service.OrderService;
import com.ilex.codingchallenge.unittest.utils.OrderTestUtils;

/**
 * @author Vincent Geng
 *
 * Created on Dec 20, 2020
 */
@WebMvcTest(OrderController.class)
public class OrderControllerUnitTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderService orderService;
	
	@Test
	@DisplayName("POST /orders place orders")
	public void testPlaceOrders() throws Exception {
		when(orderService.placeOrders(any(OrderDTO.class))).thenReturn(Arrays.asList(OrderTestUtils.mockOrder()));
		this.mockMvc.perform(post("/orders")
								.contentType(MediaType.APPLICATION_JSON)
								.content(new ObjectMapper().writeValueAsString(OrderTestUtils.mockOrderDTO())))
					.andExpect(status().isCreated())
					.andExpect(jsonPath("$").exists())
					.andExpect(jsonPath("$.*", hasSize(1)))
					.andExpect(jsonPath("$[0].orderId", is(1)))
					.andExpect(jsonPath("$[0].user.userId", is(1)))
					.andExpect(jsonPath("$[0].user.userName", is("User 1")))
					.andExpect(jsonPath("$[0].creationDate", is("2020-12-19T16:00:00.000+00:00")))
					.andExpect(jsonPath("$[0].price", is(1300.00)))
					.andExpect(jsonPath("$[0].product.productId", is(1)))
					.andExpect(jsonPath("$[0].product.productName", is("iPhone 12")))
					.andExpect(jsonPath("$[0].product.productDescription", is("Smart phone")));
	}
	
	@Test
	@DisplayName("GET /orders list orders")
	public void testListOrders() throws Exception {
		when(orderService.findByUserUserIdAndCreationDateBetween(anyLong(), any(Date.class), any(Date.class))).thenReturn(Arrays.asList(OrderTestUtils.mockOrder()));
		this.mockMvc.perform(get("/orders")
				.param("userId", "1")
				.param("fromDate", "20/12/2020")
				.param("toDate", "21/12/2020"))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$").exists())
					.andExpect(jsonPath("$.*", hasSize(1)))
					.andExpect(jsonPath("$[0].orderId", is(1)))
					.andExpect(jsonPath("$[0].user.userId", is(1)))
					.andExpect(jsonPath("$[0].user.userName", is("User 1")))
					.andExpect(jsonPath("$[0].creationDate", is("2020-12-19T16:00:00.000+00:00")))
					.andExpect(jsonPath("$[0].price", is(1300.00)))
					.andExpect(jsonPath("$[0].product.productId", is(1)))
					.andExpect(jsonPath("$[0].product.productName", is("iPhone 12")))
					.andExpect(jsonPath("$[0].product.productDescription", is("Smart phone")));
	}

}
