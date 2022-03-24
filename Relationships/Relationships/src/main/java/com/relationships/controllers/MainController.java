package com.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.relationships.models.License;
import com.relationships.models.Person;
import com.relationships.services.LicenseService;
import com.relationships.services.PersonService;

@Controller
public class MainController {
	
	
	private final PersonService personService;
	private final LicenseService licenseService;

	public MainController(PersonService personService,LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@GetMapping("/persons/{person_id}")
	public String showPerson(@PathVariable Long person_id, Model model) {
	    
	    Person someAwesomePerson = personService.findPerson(person_id);
	    model.addAttribute("person", someAwesomePerson);
	    
	    return "showPerson.jsp";
	}
	
	@PostMapping("/licenses")
	public String licenses(@Valid @ModelAttribute("license") License license) {
	    // error handling with binding result omitted    
	    licenseService.createLicense(license); // Already has the person!
	        
	    return "redirect:/persons";
	}

}
