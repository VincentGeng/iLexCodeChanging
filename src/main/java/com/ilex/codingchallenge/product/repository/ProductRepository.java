package com.ilex.codingchallenge.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.ilex.codingchallenge.product.entity.Product;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

}
