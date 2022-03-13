package com.example.queryparameters;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryTest {
	@RequestMapping("/")
	public String index(@RequestParam(value="q" , required = false) String searchQuery) {
		if (searchQuery == null) {
			return "You have searched for nothing:";
		}else {
			return "You have searched for: " + searchQuery;
		}
		
	}
	
	

}
