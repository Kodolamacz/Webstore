package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.OrderRepo;
import com.packt.webstore.domain.repository.ProductsRepository;
import com.packt.webstore.service.CartService;
import com.packt.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private ProductsRepository productsRepository;
	
	public void processOrder(String productId, int count){
		Product productById = productsRepository.getProductById(productId);
		if(productById.getUnitsInStock() < count){
			throw new IllegalArgumentException("Zbyt malo towaru. Obecna liczba w magaznie: " + productById.getUnitsInStock());
		}
		productById.setUnitsInStock(productById.getUnitsInStock() - count);
	}
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private CartService cartService;
	
	

	@Override
	public Long saveOrder(Order order) {
		Long orderId = orderRepo.saveOrder(order);
		cartService.delete(order.getCart().getCartId());
		return orderId;
	}
}
