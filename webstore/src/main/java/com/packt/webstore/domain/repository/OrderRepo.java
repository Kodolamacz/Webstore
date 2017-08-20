package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Order;

public interface OrderRepo {
	
	Long saveOrder(Order order);
}
