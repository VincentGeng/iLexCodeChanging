package com.ilex.codingchallenge.product.entity;

import java.util.List;

import com.ilex.codingchallenge.tag.Tag;

/**
 * @author Vincent Geng
 *
 * Created on Dec 18, 2020
 */
public class Product {
	private Long productId;
	private String productName;
	private String productDescription;
	private List<Tag> tags;
	private Double price;
	
	public Product() {
	}

	public Long getProductId() {
		return productId;
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
	
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
