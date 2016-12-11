package com.emusicstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.nio.file.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request) {
		productDao.addProduct(product);
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductID() + ".png");
		if(productImage != null && !productImage.isEmpty()){
			try{
				productImage.transferTo(new File(path.toString())); //saves the image to this directory path and saves to new type .png file
			} catch(Exception e){   
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed.", e);
			}
		}
		return "redirect:/admin/productInventory"; //Redirecting to a different path -- can't just put productInventory because modeling hasn't been done for the added object
	}   //Redirect tells the controller that this is not a JSP page but it is a pathname


	/*
	 * deleteProduct JSP view corresponding to the product's ID
	 */
	@RequestMapping("/admin/productInventory/deleteProduct/{productID}")
	public String deleteProduct(@PathVariable String productID, Model model){
		productDao.deleteProduct(productID);
		return "redirect:/admin/productInventory";
	}
}
