package com.ilex.codingchallenge.unittest.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ilex.codingchallenge.product.dto.ProductDTO;
import com.ilex.codingchallenge.product.entity.Product;
import com.ilex.codingchallenge.tag.entity.Tag;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public class ProductTestUtils {
	public static Product mockProduct(){
		Product product = new Product();
		product.setProductId(1l);
		product.setProductName("iPhone 12");
		product.setProductDescription("Smart phone");
		List<Tag> tags = new ArrayList<>();
		Tag tag = new Tag("PHONE");
		tag.setTagId(1l);
		tags.add(tag);
		product.setTags(tags);
		return product;
	}
	
	public static ProductDTO mockProductDTO(){
		ProductDTO product = new ProductDTO();
		product.setProductName("iPhone 12");
		product.setProductDescription("Smart phone");
		product.setTagNames(Arrays.asList("PHONE"));
		return product;
	}
}
