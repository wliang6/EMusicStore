package com.emusicstore.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//private ProductDao ProductDao = new ProductDao();
	
	private Path path;
	
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
	

}
