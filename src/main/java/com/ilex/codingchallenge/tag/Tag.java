package com.ilex.codingchallenge.tag;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
	
	@ManyToMany(mappedBy = "tags")
    private List<Product> products = new ArrayList<>();
	
	public Tag() {
	}
	
	public Long getTagId() {
		return tagId;
	}
	
	public String getName() {
		return name;
	}
	
}
