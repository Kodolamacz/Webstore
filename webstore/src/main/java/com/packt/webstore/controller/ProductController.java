package com.packt.webstore.controller;



import java.util.LinkedList;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.service.ProductService;

@RequestMapping("/products")
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String list(Model model){
		model.addAttribute("products",productService.getAllProducts());
		return "products";
	}
	@RequestMapping("/all")
	public String allProd(Model model){
		model.addAttribute("products",productService.getAllProducts());
		return "products";
	}
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory){
		model.addAttribute("products",productService.getProductsByCategory(productCategory));
		return "products";
	}
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria")
	Map<String, LinkedList<String>> filterParams,Model model){
		model.addAttribute("products",productService.getProductsByFilter(filterParams));
		return "products";
	}
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model){
		model.addAttribute("product",productService.getProductById(productId));
		return "product";
	}
	@RequestMapping("/{category}/{price}")
	public String getFilterProducts(Model model, @PathVariable("category") String category, @MatrixVariable(pathVar="price") 
	Map<String, LinkedList<String>> filterParams, @RequestParam("manufacturer") String manufacturer){
		model.addAttribute("products",productService.getFilterProducts(category, filterParams, manufacturer));
		return "products";
		
	}
}
