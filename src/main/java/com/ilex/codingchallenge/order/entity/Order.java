package com.ilex.codingchallenge.order.entity;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.ilex.codingchallenge.product.entity.Product;
import com.ilex.codingchallenge.user.entity.User;

/**
 * @author Vincent Geng
 *
 * Created on Dec 18, 2020
 */
@Entity
@Table(name = "order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "int(11)", nullable = false)
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
	@Column(name = "creation_date", columnDefinition = "datetime")
	private Date creationDate;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "order_product", 
        joinColumns = { @JoinColumn(name = "order_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
	private List<Product> products = new ArrayList<>();
	
	public Order() {
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}
