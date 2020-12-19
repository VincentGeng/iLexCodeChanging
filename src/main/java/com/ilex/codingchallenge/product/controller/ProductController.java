package com.ilex.codingchallenge.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ilex.codingchallenge.product.dto.ProductDTO;
import com.ilex.codingchallenge.product.entity.Product;
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
	
	// List products
    @GetMapping("/products")
    public List<Product> listProducts() {
        return productService.findAll();
    }

    // Add product
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductDTO productDto) {
        return productService.addNewProduct(productDto);
    }

}
