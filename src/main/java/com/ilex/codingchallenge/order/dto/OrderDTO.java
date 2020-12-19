package com.ilex.codingchallenge.order.dto;

import java.util.List;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public class OrderDTO {
	
	private List<ProductPriceDTO> products;
	private Long userId;
	
	public OrderDTO() {
	}
	
	public List<ProductPriceDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductPriceDTO> products) {
		this.products = products;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
