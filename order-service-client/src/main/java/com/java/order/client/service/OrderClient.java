package com.java.order.client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.order.client.model.OrderItem;

@FeignClient(name = "orderItemClient", url = "http://localhost:8080/")
public interface OrderClient {
	@RequestMapping(value = "/getAllOrderItems", method = RequestMethod.GET)
	List<OrderItem> getAllOrderItems();

	
	 @RequestMapping(value="/getOrderItem/{productCode}",method=RequestMethod.GET)
	  Optional<OrderItem> findOrderItemByItemId(@PathVariable int productCode);
	 

}
