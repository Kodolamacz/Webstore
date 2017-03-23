package com.packt.webstore.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductsRepository;
import com.packt.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductsRepository productsRepository;
	
	public ArrayList<Product> getAllProducts(){
		return productsRepository.getAllProducts();
		 
	}
	public ArrayList<Product> getProductsByCategory(String category) {
		return productsRepository.getProductByCategory(category);
	}
	public Set<Product> getProductsByFilter(
			Map<String, LinkedList<String>> filterParams) {
		
		return productsRepository.getProductsByFilter(filterParams);
	}
	public Product getProductById(String productId){
		return productsRepository.getProductById(productId);
	}
	public ArrayList<Product> getProductsByManufacturer(String manufacturer){
		return productsRepository.getProductsByManufacturer(manufacturer);
	}
	public Set<Product> getProductsByPrice(Map<String, LinkedList<String>> filterParams){
		return productsRepository.getProductsByPrice(filterParams);
	}
	public Set<Product> getFilterProducts(String category, Map<String, LinkedList<String>> filterParams, String manufacturer){
		return productsRepository.getFilterProducts(category, filterParams, manufacturer);
	}


    public void addProduct(Product product) {
    	productsRepository.addProduct(product);
    }
}
