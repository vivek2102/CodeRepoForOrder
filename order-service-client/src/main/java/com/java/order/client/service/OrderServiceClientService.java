package com.java.order.client.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.order.client.dao.OrderSerrviceClientDao;
import com.java.order.client.model.Order;

@Service
public class OrderServiceClientService {
	@Autowired 
	OrderSerrviceClientDao dao;


	public void saveOrders(Order order) {
		// TODO Auto-generated method stub
		 dao.save(order);
		 
	}
	
	public Optional<Order> findOrderByOrderId(int orderId) {
		System.out.println("orderid:"+orderId);
		Optional<Order> o=dao.findById(orderId);
		return o;
	}
	
	

}
