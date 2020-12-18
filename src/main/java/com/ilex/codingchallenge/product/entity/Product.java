package com.ilex.codingchallenge.product.entity;

import java.util.List;

/**
 * @author Vincent Geng
 *
 * Created on Dec 18, 2020
 */
public class Product {
	private Long productId;
	private String productName;
	private String productDescription;
	private List<String> tags;
	private Double price;
	
	public Product() {
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
