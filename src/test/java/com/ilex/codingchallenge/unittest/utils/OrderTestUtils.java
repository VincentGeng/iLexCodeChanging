package com.ilex.codingchallenge.unittest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.ilex.codingchallenge.order.dto.OrderDTO;
import com.ilex.codingchallenge.order.dto.ProductPriceDTO;
import com.ilex.codingchallenge.order.entity.Order;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public class OrderTestUtils {
	public static Order mockOrder() throws ParseException{
		Order order = new Order();
		order.setOrderId(1l);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String dateInString = "20-Dec-2020";
		Date creationDate = formatter.parse(dateInString);
		order.setCreationDate(creationDate);
		order.setPrice(1300.00);
		order.setProduct(ProductTestUtils.mockProduct());
		order.setUser(UserTestUtils.mockUser());
		return order;
	}

	/**
	 * @return
	 */
	public static OrderDTO mockOrderDTO() {
		OrderDTO order = new OrderDTO();
		ProductPriceDTO productPriceDto = new ProductPriceDTO();
		productPriceDto.setProductId(1l);
		productPriceDto.setPrice(1300.00);
		order.setProducts(Arrays.asList(productPriceDto));
		order.setUserId(1l);
		return order;
	}
}
