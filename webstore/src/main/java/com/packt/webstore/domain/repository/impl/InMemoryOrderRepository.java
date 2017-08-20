package com.packt.webstore.domain.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.repository.OrderRepo;
import com.packt.webstore.service.CartService;

@Repository
public class InMemoryOrderRepository implements OrderRepo {

	private Map<Long, Order> listOfOrders;
	private long nextOrderId;
	public InMemoryOrderRepository() {
		listOfOrders = new HashMap<Long, Order>();
		nextOrderId = 1000;
	}
	@Override
	public Long saveOrder(Order order) {
		order.setOrderId(getNextOrderId());
		listOfOrders.put(order.getOrderId(), order);
		return order.getOrderId();
	}
	private synchronized long getNextOrderId() {
		return nextOrderId++;
	}
	
	
}
