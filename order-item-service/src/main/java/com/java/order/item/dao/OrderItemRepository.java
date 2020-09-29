package com.java.order.item.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.order.item.model.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer>{
	

}
