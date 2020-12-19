package com.ilex.codingchallenge.order.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    // List orders
    @GetMapping("/orders")
    public List<Order> listOrders(@RequestParam(value = "userId") Long userId,
    							@DateTimeFormat(pattern="dd/MM/yyyy") @RequestParam(value = "fromDate") Date fromDate,
    							@DateTimeFormat(pattern="dd/MM/yyyy") @RequestParam(value = "toDate") Date toDate) {
        return orderService.findByUserUserIdAndCreationDateBetween(userId, fromDate, toDate);
    }

}
