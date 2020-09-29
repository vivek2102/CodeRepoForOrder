package com.java.order.item.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.order.item.dao.OrderItemRepository;
import com.java.order.item.exception.ResourceNotFoundException;
import com.java.order.item.model.OrderItem;

@RestController
public class OrderItemController {
	@Autowired
	private OrderItemRepository repository;
	
	@PostMapping("/saveOrderItem")
	public String saveOrder(@RequestBody OrderItem order) throws ResourceNotFoundException{
		if(order ==null) {
			throw new ResourceNotFoundException("Blank Request");
		}
		repository.save(order);
		return "Employee saved successfully";
	}
	
	@GetMapping("/getAllOrderItems")
	public List<OrderItem> getAll(){
		return (List<OrderItem>) repository.findAll();
		
	}
	
	@GetMapping("/getOrderItem/{productCode}")
	public Optional<OrderItem> getOrdersByProductCode(@PathVariable int productCode) throws ResourceNotFoundException{	
		Optional<OrderItem> orderItem=  repository.findById(productCode);
		if(orderItem.get()==null) {
			throw new ResourceNotFoundException("Order Not Found");
		}
		return orderItem;
		
	}

}
