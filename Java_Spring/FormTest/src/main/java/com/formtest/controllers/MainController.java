package com.formtest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
		@RequestParam(value="email") String email,
	    	@RequestParam(value="password") String password) {
	    
	    	// CODE TO PROCESS FORM ie. check email and password
	    	
	    	return "result.jsp"; // <-- we'll change this when we learn redirecting
	}

}
