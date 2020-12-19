package com.ilex.codingchallenge.product.service;

import java.util.List;

import com.ilex.codingchallenge.product.dto.ProductDTO;
import com.ilex.codingchallenge.product.entity.Product;

/**
 * @author Vincent Geng
 *
 * Created on Dec 18, 2020
 */
public interface ProductService {

	/**
	 * @return
	 */
	List<Product> findAll();

	/**
	 * @param product
	 * @return
	 */
	Product addNewProduct(ProductDTO product);

}
