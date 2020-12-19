package com.ilex.codingchallenge.order.service;

import java.util.Date;
import java.util.List;

import com.ilex.codingchallenge.order.dto.OrderDTO;
import com.ilex.codingchallenge.order.entity.Order;

/**
 * @author Vincent Geng
 *
 * Created on Dec 18, 2020
 */
public interface OrderService {

	/**
	 * @param orderDTO
	 * @return
	 */
	List<Order> placeOrders(OrderDTO orderDTO);

	/**
	 * @param userId
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	List<Order> findByUserUserIdAndCreationDateBetween(Long userId, Date fromDate, Date toDate);

}
