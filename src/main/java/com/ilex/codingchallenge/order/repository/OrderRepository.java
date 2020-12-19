package com.ilex.codingchallenge.order.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ilex.codingchallenge.order.entity.Order;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

	/**
	 * @param userId
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	List<Order> findByUserUserIdAndCreationDateBetween(Long userId, Date fromDate, Date toDate);

}
