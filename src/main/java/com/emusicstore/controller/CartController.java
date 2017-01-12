package com.emusicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emusicstore.dao.CartDao;
import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Cart;

//This CartController will mainly provide REST services
@Controller
@RequestMapping("/rest/cart")
public class CartController {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value = "/{cartId}", method=RequestMethod.GET)
	//@ResponseBody allows Spring to pass the cart object in JSON format and sends response as a responseBody
	//We can manipulate the responseBody through other annotations: addResponseEntity - gives flexibility to control header and HTTPResponse header as well  
	//Retrieve cartId from path variable and put it as a new string.
	//Access cartDao object to read cartId. 
	public @ResponseBody Cart read (@PathVariable(value="cartId") String cartId) {
		return cartDao.read(cartId);
	}

}
