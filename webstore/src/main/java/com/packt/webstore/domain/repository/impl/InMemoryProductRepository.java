package com.packt.webstore.domain.repository.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.exception.ProductNotFoundException;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductsRepository;

@Repository
public class InMemoryProductRepository implements ProductsRepository{

		private ArrayList<Product> listOfProducts = new ArrayList<Product>();
		public InMemoryProductRepository(){
			
			Product iphone = new Product("P12345","Iphone 4s",new BigDecimal(500));
			iphone.setDescription("OPIS AJFONA");
			iphone.setCategory("Smartfon");
			iphone.setManufacturer("Apple");
			iphone.setUnitsInStock(1000);
			
			Product laptop_Dell = new Product("P12346","Dell Inspiron",new BigDecimal(500));
			laptop_Dell.setDescription("OPIS della");
			laptop_Dell.setCategory("laptop");
			laptop_Dell.setManufacturer("Dell");
			laptop_Dell.setUnitsInStock(1000);
			
			Product tablet_nexus = new Product("P12347","Nexus 7",new BigDecimal(300));
			tablet_nexus.setDescription("OPIS tableta");
			tablet_nexus.setCategory("Tablet");
			tablet_nexus.setManufacturer("Google");
			tablet_nexus.setUnitsInStock(1000);
		
			listOfProducts.add(iphone);
			listOfProducts.add(laptop_Dell);
			listOfProducts.add(tablet_nexus);
			
		}
		public ArrayList<Product> getAllProducts(){
			return listOfProducts;
		}

		public Product getProductById(String productId){
			Product productById = null;
			for(Product product : listOfProducts){
				if(product != null && product.getProductId() != null &&
						product.getProductId().equals(productId)){
					productById = product;
					break;
				}
			}
			if(productById == null){
				throw new ProductNotFoundException(productId);
			}
			return productById;
		}
		
		public ArrayList<Product> getProductByCategory(String category){
			ArrayList<Product> productsByCategory = new ArrayList<Product>();

			for(Product product : listOfProducts){
				if(category.equalsIgnoreCase(product.getCategory())){
					productsByCategory.add(product);
				}
			}
			return productsByCategory;
		}
		public Set<Product> getProductsByFilter(Map<String, LinkedList<String>> filterParams){
			Set<Product> productsByBrand = new HashSet<Product>();
			Set<Product> productsByCategory = new HashSet<Product>();
			Set<String> criterias = filterParams.keySet();
			if(criterias.contains("brand")){
				for(String brandName : filterParams.get("brand")){
					for(Product product : listOfProducts){
						if(brandName.equalsIgnoreCase(product.getManufacturer()))
							productsByBrand.add(product);
					}
				}
			}
				if(criterias.contains("category")){
					for(String category : filterParams.get("category")){
						productsByCategory.addAll(this.getProductByCategory(category));
					}
				}
				productsByCategory.retainAll(productsByBrand);
				return productsByCategory;
		}
		public ArrayList<Product> getProductsByManufacturer(String manufacturer){
			ArrayList<Product> productsByManufacturer = new ArrayList<Product>();
			for (Product product : listOfProducts) {
				if(product.getManufacturer().equals(manufacturer)){
					productsByManufacturer.add(product);
				}
			}
			return productsByManufacturer;
		}
		public Set<Product> getProductsByPrice(Map<String, LinkedList<String>> filterParams){
			Set<Product> productsLowPrice = new HashSet<Product>();
			Set<Product> productsHighPrice = new HashSet<Product>();
			Set<String> criterias = filterParams.keySet();
			if(criterias.contains("low")){
				for(String lowPrice : filterParams.get("low")){
					for(Product product : listOfProducts){
						if(product.getUnitPrice().compareTo(BigDecimal.valueOf(Double.valueOf(lowPrice))) == 0 ||
								product.getUnitPrice().compareTo(BigDecimal.valueOf(Double.valueOf(lowPrice))) == 1	){
							productsLowPrice.add(product);
						}
					}
				}
			}
			if(criterias.contains("high")){
				for(String highPrice : filterParams.get("high")){
					for(Product product : listOfProducts){
						if(product.getUnitPrice().compareTo(BigDecimal.valueOf(Double.valueOf(highPrice))) == 0 ||
								product.getUnitPrice().compareTo(BigDecimal.valueOf(Double.valueOf(highPrice))) == -1	){
							productsHighPrice.add(product);
						}
					}
				}
			}
			productsHighPrice.retainAll(productsLowPrice);
			return productsHighPrice;
			
		}
		public Set<Product> getFilterProducts(String category, Map<String, LinkedList<String>> filterParams, String manufacturer){
			//Set<Product> filteredProducts = new HashSet<Product>();
			Set<Product> priceFilteredProducts = getProductsByPrice(filterParams);
			ArrayList<Product> productsByCategory = getProductByCategory(category);
			ArrayList<Product> productsByManufacturer = getProductsByManufacturer(manufacturer);
			priceFilteredProducts.retainAll(productsByCategory);
			priceFilteredProducts.retainAll(productsByManufacturer);
			return priceFilteredProducts;
			
		}


    public void addProduct(Product product) {
        listOfProducts.add(product);
    }
}
