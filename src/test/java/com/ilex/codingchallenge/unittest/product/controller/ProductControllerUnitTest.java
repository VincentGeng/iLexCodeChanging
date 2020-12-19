package com.ilex.codingchallenge.unittest.product.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.ilex.codingchallenge.product.controller.ProductController;
import com.ilex.codingchallenge.product.service.ProductService;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
@WebMvcTest(ProductController.class)
public class ProductControllerUnitTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;
	
	@Test
	@DisplayName("GET /products list products")
	public void testListProducts() throws Exception {
		when(productService.findAll()).thenReturn(new ArrayList<>());
		this.mockMvc.perform(get("/products"))
					.andExpect(status().isOk());
	}

}
