package com.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojosninjas.models.Dojo;
import com.dojosninjas.models.Ninja;
import com.dojosninjas.services.DojoService;
import com.dojosninjas.services.NinjaService;


@Controller
public class MainController {
	
	private final DojoService dojoService;
	private final NinjaService ninjaService;

	public MainController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@GetMapping("/ninjas/new")
    public String newNinja(Model model , @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "Ninja.jsp";
    }
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "Dojo.jsp";
	}
	
	
	@PostMapping("/dojos")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "Dojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@PostMapping("/ninjas")
	public String createNew(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "Ninja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/")
	public String dashboard(Model model) {

		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);

		return "main.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String index(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "info.jsp";
	}

    }


