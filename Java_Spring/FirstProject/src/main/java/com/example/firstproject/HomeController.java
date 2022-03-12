package com.example.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {
	@RequestMapping("")
	public String hello() {
		return "Hello World! fhht";
	}
	@RequestMapping("/Mohammad")
	public String wow() {
		return "Hello, My name is Mohammad Omair and I'm currently learning spring boot";
	}

}
