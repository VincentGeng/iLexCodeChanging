package com.ilex.codingchallenge.product.dto;

import java.util.List;

import com.ilex.codingchallenge.product.entity.Product;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public class ProductDTO extends Product {
	private List<String> tagNames;

	public List<String> getTagNames() {
		return tagNames;
	}

	public void setTagNames(List<String> tagNames) {
		this.tagNames = tagNames;
	}
	
}
