package com.example.testjsp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/")
		public String index() {
		return "<h1 style='color: red;'>Hello world</h1>";
			
		}	
	}
	
