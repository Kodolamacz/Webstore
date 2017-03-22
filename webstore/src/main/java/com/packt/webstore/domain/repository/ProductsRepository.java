package com.packt.webstore.domain.repository;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.Product;

public interface ProductsRepository {
	ArrayList<Product>  getAllProducts();
	Product getProductById(String productId);
	ArrayList<Product> getProductByCategory(String category);
	Set<Product> getProductsByFilter(Map<String, LinkedList<String>> filterParams);
	ArrayList<Product> getProductsByManufacturer(String manufacturer);
	Set<Product> getProductsByPrice(Map<String, LinkedList<String>> filterParams);
	Set<Product> getFilterProducts(String category, Map<String, LinkedList<String>> filterParams, String manufacturer);
}
