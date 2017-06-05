package com.packt.webstore.controller;



import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;


import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.validator.ProductValidator;
import com.packt.webstore.validator.UnitsInStockValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.packt.webstore.service.ProductService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequestMapping("/products")
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductValidator productValidator;

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
		ArrayList<Product> products = productService.getProductsByCategory(productCategory);
		if(products == null || products.isEmpty()){
			throw  new NoProductsFoundUnderCategoryException();
		}
		model.addAttribute("products",products);
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

	@RequestMapping(value = "/add/p", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model){
		Product newProduct = new Product();
		model.addAttribute("newProduct",newProduct);
		return "addProduct";
	}
	
	@RequestMapping(value ="/add/p", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct,
										   BindingResult result,
										   HttpServletRequest request){
		if(result.hasErrors()){
			return "addProduct";
		}
		String [] suppressedFiled = result.getSuppressedFields();
		if(suppressedFiled.length > 0){
			throw  new RuntimeException("Próba wiązania niedozwolonych pół: " +
					StringUtils.arrayToCommaDelimitedString(suppressedFiled));
		}

		MultipartFile productImage = newProduct.getProductImage();
		MultipartFile productManual = newProduct.getProductManual();

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

        if(productImage != null && !productImage.isEmpty()){
			try{

				File image = new File(rootDirectory+"/resources/images/" +
						newProduct.getProductId() + ".png");

				productImage.transferTo(image);

			}catch (Exception e){
				throw  new RuntimeException("Niepowodzenie podczas proby zapisu obrazka.",e);
			}
		}
		if(productManual!= null && !productManual.isEmpty()){
			try{
				productManual.transferTo(new File(rootDirectory+"/resources/PDF/" +
						newProduct.getProductId() + ".pdf"));
			}catch (Exception e){
			    e.printStackTrace();
				throw  new RuntimeException("Niepowodzenie podczas proby zapisu instrukcji.",e);
			}
		}
		productService.addProduct(newProduct);
		return "redirect:/products";
	}
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setAllowedFields("productId","name","unitPrice","description",
				"manufacturer","category","unitsInStock","productImage","productManual","language");
		binder.setDisallowedFields("unitsInOrder","discontinued");
		binder.setValidator(productValidator);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest request, ProductNotFoundException exception){
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId",exception.getProductId());
		mav.addObject("exception",exception);
		mav.addObject("url",request.getRequestURL() + "?"+request.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}

}
