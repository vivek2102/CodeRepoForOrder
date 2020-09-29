package com.java.order.client.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.order.client.exception.ResourceNotFoundException;
import com.java.order.client.model.Order;
import com.java.order.client.model.OrderItem;
import com.java.order.client.service.OrderClient;
import com.java.order.client.service.OrderServiceClientService;

@RestController
public class OrderClientController {
	@Autowired
	private OrderClient client;
	@Autowired
	OrderServiceClientService service;


	@PostMapping("/saveOrder")
	public String saveOrder(@RequestBody Order order) throws ResourceNotFoundException {
		if(order ==null) {
			throw new ResourceNotFoundException("Blank Request");
		}
		for (int i = 0; i < order.getOrderItems().size(); i++) {
			order.setOrderItemId(order.getOrderItems().get(i).getProductCode());
			service.saveOrders(order);
		}
		return "Order Saved Successfully";

	}
	
	
	@GetMapping("/getOrdersByOrderId/{orderId}")
	public Optional<Order> getOrderByOrderId(@PathVariable int orderId) throws ResourceNotFoundException {
		Optional<Order> order=service.findOrderByOrderId(orderId);
		if(order.get()==null) {
			throw new ResourceNotFoundException("Order Not Found");
		}
		Optional<OrderItem> orderItem=client.findOrderItemByItemId(order.get().getOrderItemId());
		ArrayList<OrderItem> l1=new ArrayList<>();
		l1.add(orderItem.get());
		order.get().setOrderItems(l1);				
		return order;
		
	}
	
	
	

}
