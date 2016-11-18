package com.emusicstore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//private ProductDao ProductDao = new ProductDao();
	
	@Autowired
	private ProductDao productDao;
	
	
	
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
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products", products); //attaching products to model
		return "productList";   //the name of jsp page
	}
	
	/*
	 * viewProduct JSP view corresponding to the product's ID
	 */
	@RequestMapping("/productList/viewProduct/{productID}")
	public String viewProduct(@PathVariable String productID, Model model) throws IOException{
		Product product = productDao.getProductByID(productID);
		model.addAttribute(product);
		return "viewProduct";
	}
	
	/*
	 * admin JSP view
	 */
	@RequestMapping("/admin")
	public String adminPage() {
		return "admin";
	}
	
	/*
	 * productInventory JSP view for admin
	 */
	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model){
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products", products);
		return "productInventory";
	}
	
	
	/*
	 * addProduct JSP view for admin
	 */
	@RequestMapping("/admin/productInventory/addProduct")
	public String addProduct(Model model){
		Product product = new Product();
		product.setProductCategory("instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");
		model.addAttribute("product", product);
		return "addProduct";
	}
	
	/*
	 * AFTER added product on addProduct JSP, specify method as POST request
	 */
	@RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product) {
		productDao.addProduct(product);
		return "redirect:/admin/productInventory"; //Redirecting to a path -- can't just put productInventory because modeling hasn't been done for the added object
	}
}
