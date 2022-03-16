package com.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@GetMapping("/omikuji")
		public String index() {
			return "index.jsp";
		}

		
	@PostMapping("/omikuji/process")
		public String process(HttpSession session,
				@RequestParam(value="number") Integer number,
			    @RequestParam(value="city") String city,
			    @RequestParam(value="person") String person,
			    @RequestParam(value="hobby") String hobby,
			    @RequestParam(value="thing") String thing,
			    @RequestParam(value="saying") String saying) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("saying", saying);
			return "redirect:/omikuji/show";
		}

	@GetMapping("/omikuji/show")
		public String show(Model model, HttpSession session) {
		Integer number = (Integer) session.getAttribute("number");
		String city = (String) session.getAttribute("city");
		String person = (String) session.getAttribute("person");
		String hobby = (String) session.getAttribute("hobby");
		String thing = (String) session.getAttribute("living");
		String saying = (String) session.getAttribute("nice");
		
		model.addAttribute("years", number);
		model.addAttribute("city", city);
		model.addAttribute("person", person);
		model.addAttribute("hobby", hobby);
		model.addAttribute("living", thing);
		model.addAttribute("nice", saying);
		return "show.jsp";
	}
	}

		//Or you can subtitute data directly without assigning them to variables like below:
			//model.addAttribute("years", session.getAttribute("years"));
			//model.addAttribute("city", session.getAttribute("city"));
			//model.addAttribute("person", session.getAttribute("person"));
			//model.addAttribute("hobby", session.getAttribute("hobby"));
			//model.addAttribute("living", session.getAttribute("living"));
			//model.addAttribute("nice", session.getAttribute("nice"));
			
		
