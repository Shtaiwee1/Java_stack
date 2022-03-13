package com.example.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanTest {
	@RequestMapping("/")
	public String index(@RequestParam(value="name" , required = false) String searchQuery , @RequestParam(value="last_name" , required = false) String searchQuery2 , @RequestParam(value="times" , required = false) String searchQuery3) {
		if (searchQuery == null) {
			return "Hello Human" + "! ";
		}else if(searchQuery2 == null){
			return "Hello " + searchQuery + "! ";
		}else if(searchQuery3 == null) {
			return "Hello " + searchQuery + " " + searchQuery2 + "! ";
		}else {
			int repeatstr = Integer.parseInt(searchQuery3);
			String result = " Hello " + searchQuery + " " + searchQuery2 + "! ";
			return result.repeat(repeatstr);
			
		}
		
	}

}
