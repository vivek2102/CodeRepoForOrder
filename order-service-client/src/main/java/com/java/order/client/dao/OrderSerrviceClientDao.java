package com.java.order.client.dao;

import org.springframework.data.repository.CrudRepository;
import com.java.order.client.model.Order;

public interface OrderSerrviceClientDao extends CrudRepository<Order, Integer> {

}
