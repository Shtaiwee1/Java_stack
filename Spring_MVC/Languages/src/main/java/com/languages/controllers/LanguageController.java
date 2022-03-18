package com.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.languages.models.Language;
import com.languages.services.LanguageService;




@Controller
public class LanguageController {
	@Autowired
	LanguageService languageService;
	
	@GetMapping("/languages")
    public String newLanguage(Model model , @ModelAttribute("language") Language language) {
		List<Language>languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
        return "index.jsp";
    }
	
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
		
		
	}
	
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
	
	@PutMapping("/languages/{id}/edit")
	public String update(@PathVariable("id") Long id,@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			languageService.updateLanguage(id,language);
			return "redirect:/languages";
		}

}
	
	@GetMapping("/languages/{id}")
	public String index(Model model,@PathVariable("id")Long id) {
	Language language = languageService.findLanguage(id);
	model.addAttribute("language", language);
	return "info.jsp";
}
	
	
	@DeleteMapping("/languages/{id}")
	    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
		    }

}
