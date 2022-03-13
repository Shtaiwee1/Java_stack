package com.example.daikichiroutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("")
	public String firstRoute() {
		return  "Welcome!";
		
	}
	@RequestMapping("/today")
	public String secondRoute() {
		return "Today you will find luck in all your endeavors!";
	}
	@RequestMapping("/tomorrow")
	public String thirdRoute() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
}
