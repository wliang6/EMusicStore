package com.emusicstore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private ProductDao ProductDao = new ProductDao();
	
	//***Request Mappings links the jsp path or the "views" to the controller***
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/")
	public String home() {   
		return "home";   
	}
	
	/*.
	 * Binds the data accessed from the DAO object -> to model -> then automatically to view
	 * productList JSP view
	 */
	@RequestMapping("/productList")
	public String getProducts(Model model) {
		List<Product> products = ProductDao.getProductList();
		model.addAttribute("products", products); //attaching products to model
		
		return "productList";  
	}
	
	/*
	 * viewProduct JSP view corresponding to the product's ID
	 */
	@RequestMapping("/productList/viewProduct/{productID}")
	public String viewProduct(@PathVariable String productID, Model model) throws IOException{
		Product product = ProductDao.getProductByID(productID);
		model.addAttribute(product);
		return "viewProduct";
	}
	
}
