package com.ilex.codingchallenge.order.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ilex.codingchallenge.product.entity.Product;
import com.ilex.codingchallenge.user.entity.User;

/**
 * @author Vincent Geng
 *
 * Created on Dec 18, 2020
 */
@Entity
@Table(name = "customer_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", columnDefinition = "int(11)", nullable = false)
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
	@Column(name = "creation_date", columnDefinition = "datetime")
	private Date creationDate;
	
	@Column(name = "price", columnDefinition = "decimal(12, 2)")
	private Double price;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "product_id", columnDefinition = "int(11)", nullable = false)
	private Product product;
	
	public Order() {
	}

	/**
	 * @param user
	 * @param date
	 * @param price
	 * @param product
	 */
	public Order(User user, Date creationDate, Double price, Product product) {
		this.user = user;
		this.creationDate = creationDate;
		this.price = price;
		this.product = product;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
