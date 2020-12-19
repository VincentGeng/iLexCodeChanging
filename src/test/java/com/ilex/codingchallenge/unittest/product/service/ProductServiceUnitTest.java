package com.ilex.codingchallenge.unittest.product.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ilex.codingchallenge.product.entity.Product;
import com.ilex.codingchallenge.product.repository.ProductRepository;
import com.ilex.codingchallenge.product.service.ProductService;
import com.ilex.codingchallenge.product.service.ProductServiceImpl;
import com.ilex.codingchallenge.tag.service.TagService;
import com.ilex.codingchallenge.unittest.utils.ProductTestUtils;
import com.ilex.codingchallenge.unittest.utils.TagTestUtils;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
@DisplayName("Product Service Unit Test")
@ExtendWith(MockitoExtension.class)
public class ProductServiceUnitTest {
	
	@InjectMocks
    private ProductService productService = new ProductServiceImpl();
	
	@Mock
	private ProductRepository productRepository;
	
	@Mock
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
