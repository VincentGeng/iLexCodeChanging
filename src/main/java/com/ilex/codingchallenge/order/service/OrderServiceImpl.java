package com.ilex.codingchallenge.order.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ilex.codingchallenge.exception.UserNotFoundException;
import com.ilex.codingchallenge.order.dto.OrderDTO;
import com.ilex.codingchallenge.order.dto.ProductPriceDTO;
import com.ilex.codingchallenge.order.entity.Order;
import com.ilex.codingchallenge.order.repository.OrderRepository;
import com.ilex.codingchallenge.product.entity.Product;
import com.ilex.codingchallenge.product.service.ProductService;
import com.ilex.codingchallenge.user.entity.User;
import com.ilex.codingchallenge.user.service.UserService;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
@Transactional
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;

	/* (non-Javadoc)
	 * @see com.ilex.codingchallenge.order.service.OrderService#placeOrder(com.ilex.codingchallenge.order.dto.OrderDTO)
	 */
	@Override
	public List<Order> placeOrders(OrderDTO orderDTO) {
		List<ProductPriceDTO> products = orderDTO.getProducts();
		User user = userService.findById(orderDTO.getUserId()).orElseThrow(()-> new UserNotFoundException(orderDTO.getUserId()));
		List<Long> productIds = products.stream().map(ProductPriceDTO::getProductId).collect(Collectors.toList());
		Map<Long, Product> productsMap = productService.findAllById(productIds).stream()
										.collect(Collectors.toMap(Product::getProductId, Function.identity()));
		List<Order> orders = products.stream().map(dto -> new Order(user, new Date(), dto.getPrice(), productsMap.get(dto.getProductId())))
				.collect(Collectors.toList());
		return (List<Order>) orderRepository.saveAll(orders);
	}

	/* (non-Javadoc)
	 * @see com.ilex.codingchallenge.order.service.OrderService#findByUserUserIdAndCreationDateBetween(java.lang.Long, java.util.Date, java.util.Date)
	 */
	@Override
	public List<Order> findByUserUserIdAndCreationDateBetween(Long userId, Date fromDate, Date toDate) {
		return orderRepository.findByUserUserIdAndCreationDateBetween(userId, fromDate, toDate);
	}

}
