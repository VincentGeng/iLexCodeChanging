package com.ilex.codingchallenge.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ilex.codingchallenge.order.repository.OrderRepository;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
@Transactional
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

}
