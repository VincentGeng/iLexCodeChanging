package com.ilex.codingchallenge.unittest.product.service;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ilex.codingchallenge.product.entity.Product;
import com.ilex.codingchallenge.product.repository.ProductRepository;
import com.ilex.codingchallenge.product.service.ProductService;
import com.ilex.codingchallenge.tag.service.TagService;
import com.ilex.codingchallenge.unittest.utils.ProductTestUtils;
import com.ilex.codingchallenge.unittest.utils.TagTestUtils;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
@SpringBootTest
public class ProductServiceUnitTest {
	
	@Autowired
    private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	
	@MockBean
	private TagService tagService;
	
	@Test
    @DisplayName("Test findAll Success")
	public void testFindAll() throws Exception {
		when(productRepository.findAll()).thenReturn(Arrays.asList(ProductTestUtils.mockProduct()));
		List<Product> products = productService.findAll();
		
		Assertions.assertSame(products.size(), 1);
		Assertions.assertSame(products.get(0).getProductName(), "iPhone 12");
	}
	
	@Test
    @DisplayName("Test addNewProduct Success")
	public void testAddNewProduct() throws Exception {
		when(tagService.findAll()).thenReturn(Arrays.asList(TagTestUtils.mockTag()));
		when(tagService.save(anyList())).thenReturn(Arrays.asList(TagTestUtils.mockTag()));
		when(productRepository.save(any(Product.class))).thenReturn(ProductTestUtils.mockProduct());
		
		Product product = productService.addNewProduct(ProductTestUtils.mockProductDTO());
		Assertions.assertSame(product.getProductId(), 1l);
		Assertions.assertSame(product.getProductName(), "iPhone 12");
		Assertions.assertSame(product.getProductDescription(), "Smart phone");
	}
	
	@Test
    @DisplayName("Test findAllById Success")
	public void findAllById() throws Exception {
		when(productRepository.findAllById(anyList())).thenReturn(Arrays.asList(ProductTestUtils.mockProduct()));
		List<Product> products = productService.findAllById(Arrays.asList(1l));
		
		Assertions.assertSame(products.size(), 1);
		Assertions.assertSame(products.get(0).getProductName(), "iPhone 12");
	}

}
