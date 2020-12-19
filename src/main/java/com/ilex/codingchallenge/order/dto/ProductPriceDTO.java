package com.ilex.codingchallenge.order.dto;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public class ProductPriceDTO {
	
	private Long productId;
	private Double price;
	
	public ProductPriceDTO() {
	}
	
	public ProductPriceDTO(Long productId, Double price) {
		super();
		this.productId = productId;
		this.price = price;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
