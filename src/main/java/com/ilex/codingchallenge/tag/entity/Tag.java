package com.ilex.codingchallenge.tag.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ilex.codingchallenge.product.entity.Product;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
@Entity
@Table(name = "tag")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id", columnDefinition = "int(11)", nullable = false)
	private Long tagId;
	
	@Column(name = "name", columnDefinition = "varchar(100)", nullable = false)
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "tags")
    private List<Product> products = new ArrayList<>();
	
	public Tag() {
	}
	
	/**
	 * @param tagName
	 */
	public Tag(String tagName) {
		this.name = tagName;
	}

	public Long getTagId() {
		return tagId;
	}
	
	public String getName() {
		return name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
