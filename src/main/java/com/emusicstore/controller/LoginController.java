package com.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	//When Spring intercepts the admin URL requests, it will redirect to login page
	public String login(@RequestParam (value="error", required = false) String error,
						@RequestParam (value="logout", required = false) String logout, Model model
						){
		if(error != null) {
			model.addAttribute("error", "Invalid username and password combination");
		}
		if(logout != null) {
			model.addAttribute("msg", "You have logged out successfully.");
		}
		return "login";
	}
}
