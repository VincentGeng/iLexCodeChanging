package com.ilex.codingchallenge.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ilex.codingchallenge.product.service.ProductService;

/**
 * @author Vincent Geng
 *
 * Created on Dec 18, 2020
 */

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

}
