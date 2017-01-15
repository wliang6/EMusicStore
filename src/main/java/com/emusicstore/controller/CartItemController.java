package com.emusicstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")  //at class level, it will be used throughout all the methods listed here
public class CartItemController {
	
	@RequestMapping   //at function level, this real path will just be "/cart"
	public String get(HttpServletRequest req) {
		//Using session ID as cartId as relationship is 1:1. You want an unique ID
		return "redirect:/cart/" + req.getSession(true).getId();
	}
	
	//Adding cartId to model
	@RequestMapping(value="/{cartID}", method = RequestMethod.GET)
	public String getCart(@PathVariable (value = "cartID") String cartID, Model model){
		model.addAttribute("cartID", cartID);
		return "cart"; //return to cart page
	}
}
