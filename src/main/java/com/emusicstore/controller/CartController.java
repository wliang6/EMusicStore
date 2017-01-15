package com.emusicstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.emusicstore.dao.CartDao;
import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.Product;

//This CartController will mainly provide REST services
@Controller
@RequestMapping("/rest/cart")
public class CartController {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	
	//@ResponseBody allows Spring to pass the cart object in JSON format and sends response as a responseBody
	//We can manipulate the responseBody through other annotations: addResponseEntity - gives flexibility to control header and HTTPResponse header as well  
	//Retrieve cartId from path variable and put it as a new string.
	//Access cartDao object to read cartId. 
	@RequestMapping(value="/{cartID}", method=RequestMethod.GET)
	public @ResponseBody Cart read (@PathVariable(value="cartID") String cartID) {
		return cartDao.read(cartID);
	}
	//HTTP METHODS ----
	//GET (read), POST (post info to url & take info for something else), PUT (update info), DELETE (delete info)
	@RequestMapping(value="/{cartID}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	//@RequestBody takes body of request and transfer into a cart object
	public void update(@PathVariable(value = "cartID") String cartID, @RequestBody Cart cart) {
		cartDao.update(cartID, cart);
	}
	
	@RequestMapping(value="/{cartID}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "cartID") String cartID) {
		cartDao.delete(cartID);
	}
	
	@RequestMapping(value="/add/{productID}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "productID") String productID, HttpServletRequest req) {
		String sessionId = req.getSession(true).getId();
		Cart cart = cartDao.read(sessionId);
		if(cart == null) { //if cart does not exist, create new cart with the sessionId
			cart = cartDao.create(new Cart(sessionId));
		}
		Product product = productDao.getProductByID(productID);
		if(product == null) {
			throw new IllegalArgumentException(new Exception());
		}
		cart.addCartItem(new CartItem(product));
		cartDao.update(sessionId, cart);
	}
	
	@RequestMapping(value="/remove/{productID}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable String productID, HttpServletRequest req) {
		String sessionId = req.getSession(true).getId();
		Cart cart = cartDao.read(sessionId);
		if(cart == null) { //if cart does not exist, create new cart with the sessionId
			cart = cartDao.create(new Cart(sessionId));
		}
		Product product = productDao.getProductByID(productID);
		if(product == null) {
			throw new IllegalArgumentException(new Exception());
		}
		cart.removeCartItem(new CartItem(product));
		cartDao.update(sessionId, cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Illegal request. Please verify your payload")
	public void handleClientError(Exception e) {}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal Server Error: Http 500 Error")
	public void handleServerError(Exception e) {}
}
