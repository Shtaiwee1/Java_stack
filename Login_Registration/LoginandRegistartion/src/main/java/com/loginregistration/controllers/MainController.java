package com.loginregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.loginregistration.models.User;
import com.loginregistration.services.UserService;
import com.loginregistration.validator.UserValidator;





@Controller
public class MainController {
    private final UserService userService;
    private final UserValidator userValidator;

    public MainController (UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/")
    public String start (@ModelAttribute("user") User user) {
        return "logreg.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result,
                           HttpSession session) {
        userValidator.validate(user, result);

        if (result.hasErrors()) {
            return "logreg.jsp";
        }
        else {
            userService.registerUser(user);
            session.setAttribute("id", user.getId());
            return "redirect:/home";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password, HttpSession session, RedirectAttributes r) {
        boolean success = userService.authenticateUser(email, password);

        if (email.length() < 1) {
            r.addFlashAttribute("error", "Email field cannot be blank.");
            return "redirect:/";
        }
        else if (password.length() < 1) {
            r.addFlashAttribute("error", "Please enter your password.");
            return "redirect:/";
        }
        else if (!success) {
            r.addFlashAttribute("error", "Email and password do not match.");
            return "redirect:/";
        }
        else {
            User user = userService.findByEmail(email);
            Long id = user.getId();
            session.setAttribute("id", id);
            return "redirect:/home";
        }
    }

    @GetMapping("/home")
    public String home (HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("id");
        if (session.getAttribute("id") == null) {
            return "redirect:/";
        }
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "main.jsp";
    }

    @GetMapping("/logout")
    public String logout (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
