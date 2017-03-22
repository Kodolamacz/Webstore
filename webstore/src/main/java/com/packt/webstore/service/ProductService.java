package com.packt.webstore.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.Product;

public interface ProductService {

	ArrayList<Product> getAllProducts();
	ArrayList<Product> getProductsByCategory(String category);
	Set<Product> getProductsByFilter(Map<String, LinkedList<String>> filterParams);
	Product getProductById(String productId);
	ArrayList<Product> getProductsByManufacturer(String manufacturer);
	Set<Product> getProductsByPrice(Map<String, LinkedList<String>> filterParams);
	Set<Product> getFilterProducts(String category, Map<String, LinkedList<String>> filterParams, String manufacturer);
}
