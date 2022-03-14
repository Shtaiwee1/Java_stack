package com.assignment.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	@RequestMapping("/your_server")
	public class Counter {
		
		@RequestMapping("")
	    public String index(HttpSession session) {
			if (session.getAttribute("count") == null) {
			session.setAttribute("count",0);
		}else {
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count", count + 1); 
		}
			return "index.jsp";
}
		
		

		@RequestMapping("/counter")
	    public String counter(HttpSession session, Model model) {
			if (session.getAttribute("count") == null) {
				session.setAttribute("count", 0);
			}else{
			Integer currentCount = (Integer) session.getAttribute("count");
			model.addAttribute("countToShow", currentCount);
			}
			return "count.jsp";	
}	
		//RESET
		
		@RequestMapping("/reset")
	    public String reset(HttpSession session) {
			session.setAttribute("count", 0);
			return "bonusreset.jsp";
			
		}
		
		//INCREMENT BY 2
		
		@RequestMapping("/increment")
	    public String increment(HttpSession session) {
			if (session.getAttribute("count") == null) {
			session.setAttribute("count",0);
		}else {
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count", count + 2); 
		}
			return "bonus.jsp";
}
	}
