package com.ilex.codingchallenge.product.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ilex.codingchallenge.order.entity.Order;
import com.ilex.codingchallenge.tag.Tag;

/**
 * @author Vincent Geng
 *
 * Created on Dec 18, 2020
 */
@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", columnDefinition = "int(11)", nullable = false)
	private Long productId;
	
	@Column(name = "product_name", columnDefinition = "varchar(255)", nullable = false)
	private String productName;
	
	@Column(name = "product_desc", columnDefinition = "varchar(255)")
	private String productDescription;
	
	@Column(name = "price", columnDefinition = "decimal(12, 2)")
	private Double price;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "product_tag", 
        joinColumns = { @JoinColumn(name = "product_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
	private List<Tag> tags = new ArrayList<>();
	
	@ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();
	
	public Product() {
	}

	public Long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
