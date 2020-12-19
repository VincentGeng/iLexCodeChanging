package com.ilex.codingchallenge.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.ilex.codingchallenge.order.entity.Order;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

}
