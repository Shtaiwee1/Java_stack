package com.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projectmanager.models.LoginUser;
import com.projectmanager.models.User;
import com.projectmanager.services.UserService;



@Controller
public class UserController {
	
	@Autowired
    private  UserService userService;


    @GetMapping("/")
    public String index (Model model) {
    	model.addAttribute( "newUser", new User());		
    	model.addAttribute( "newLogin", new LoginUser());
    	return "logandreg.jsp";
    }
    

    @PostMapping( "/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
    		BindingResult result,Model model, HttpSession session) {
    	userService.register(newUser , result);
        if (result.hasErrors()) {
        	model.addAttribute( "newLogin", new LoginUser());
        	return "logandreg.jsp";
        }else{
            session.setAttribute("userId", newUser.getId());
            return "redirect:/dashboard";
        }
    }

    @PostMapping( "/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
    		BindingResult result,Model model, HttpSession session){
        User user = userService.login(newLogin, result);
        if (result.hasErrors()) {
        	System.out.println(result);
        	model.addAttribute( "newUser", new User());
        	return "logandreg.jsp";
        }else{
            session.setAttribute("userId", user.getId());
            return "redirect:/dashboard";
        }
    }
    

    //@GetMapping("/home")
    //public String home (HttpSession session, Model model) {
       // Long user_id = (Long) session.getAttribute("user_id");
        
       // if (user_id == null) {
       //     return "redirect:/";
       // }else {
       // User thisUser = userService.findUserById(user_id);
       // model.addAttribute("thisUser", thisUser);
       // return "main.jsp";
       // }
    //}
    

    @GetMapping("/logout")
    public String logout (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }



	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/home";
	}

}