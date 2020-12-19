package com.ilex.codingchallenge.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ilex.codingchallenge.order.dto.OrderDTO;
import com.ilex.codingchallenge.order.entity.Order;
import com.ilex.codingchallenge.order.service.OrderService;

/**
 * @author Vincent Geng
 *
 * Created on Dec 18, 2020
 */

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	// Place Order
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/orders")
    public List<Order> placeOrders(@RequestBody OrderDTO orderDTO) {
        return orderService.placeOrders(orderDTO);
    }

}
