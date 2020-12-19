package com.ilex.codingchallenge.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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

}
