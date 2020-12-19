package com.ilex.codingchallenge.unittest.product.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilex.codingchallenge.product.controller.ProductController;
import com.ilex.codingchallenge.product.dto.ProductDTO;
import com.ilex.codingchallenge.product.entity.Product;
import com.ilex.codingchallenge.product.service.ProductService;
import com.ilex.codingchallenge.unittest.utils.ProductTestUtils;

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
		List<Product> products = Arrays.asList(ProductTestUtils.mockProduct());
		when(productService.findAll()).thenReturn(products);
		this.mockMvc.perform(get("/products"))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.*", hasSize(1)))
					.andExpect(jsonPath("$[0].productId", is(1)))
					.andExpect(jsonPath("$[0].productName", is("iPhone 12")))
					.andExpect(jsonPath("$[0].productDescription", is("Smart phone")))
					.andExpect(jsonPath("$[0].tags[0].name", is("PHONE")));
	}
	
	@Test
	@DisplayName("POST /products add product")
	public void testAddProduct() throws Exception {
		when(productService.addNewProduct(any(ProductDTO.class))).thenReturn(ProductTestUtils.mockProduct());
		this.mockMvc.perform(post("/products")
								.contentType(MediaType.APPLICATION_JSON)
								.content(new ObjectMapper().writeValueAsString(ProductTestUtils.mockProductDTO())))
					.andExpect(status().isCreated())
					.andExpect(jsonPath("$").exists())
					.andExpect(jsonPath("$.productId", is(1)))
					.andExpect(jsonPath("$.productName", is("iPhone 12")))
					.andExpect(jsonPath("$.productDescription", is("Smart phone")))
					.andExpect(jsonPath("$.tags[0].name", is("PHONE")));
	}

}
