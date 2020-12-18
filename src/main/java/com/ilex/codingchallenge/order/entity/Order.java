package com.ilex.codingchallenge.order.entity;

import java.util.List;

import com.ilex.codingchallenge.product.entity.Product;
import com.ilex.codingchallenge.user.entity.User;

/**
 * @author Vincent Geng
 *
 * Created on Dec 18, 2020
 */
public class Order {
	private Long orderId;
	private User user;
	private List<Product> products;
	
	public Order() {
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
