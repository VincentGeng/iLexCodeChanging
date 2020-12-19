package com.ilex.codingchallenge.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.ilex.codingchallenge.product.dto.ProductDTO;
import com.ilex.codingchallenge.product.entity.Product;
import com.ilex.codingchallenge.product.repository.ProductRepository;
import com.ilex.codingchallenge.tag.entity.Tag;
import com.ilex.codingchallenge.tag.service.TagService;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
@Transactional
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private TagService tagService;

	/* (non-Javadoc)
	 * @see com.ilex.codingchallenge.product.service.ProductService#findAll()
	 */
	@Override
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.ilex.codingchallenge.product.service.ProductService#addNewProduct(com.ilex.codingchallenge.product.dto.ProductDTO)
	 */
	@Override
	public Product addNewProduct(ProductDTO productDto) {
		Map<String, Tag> tagsMap = tagService.findAll().stream().collect(Collectors.toMap(Tag::getName, Function.identity()));
		List<Tag> tags = new ArrayList<>();
		if(!CollectionUtils.isEmpty(productDto.getTagNames())){
			List<Tag> tagsToCollect = productDto.getTagNames()
					.stream()
					.map(tagName -> tagName.trim().toUpperCase())
					.map(tagName -> {
						if(tagsMap.containsKey(tagName)){
							return tagsMap.get(tagName);
						}else{
							return new Tag(tagName);
						}
					}).collect(Collectors.toList());
			tags = tagService.save(tagsToCollect);
		}
		
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		product.setTags(tags);
		return productRepository.save(product);
	}

	/* (non-Javadoc)
	 * @see com.ilex.codingchallenge.product.service.ProductService#findAllById(java.util.List)
	 */
	@Override
	public List<Product> findAllById(List<Long> productIds) {
		return (List<Product>) productRepository.findAllById(productIds);
	}

}
