package com.beltexam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import com.beltexam.models.Course;
import com.beltexam.models.User;
import com.beltexam.services.CourseService;
import com.beltexam.services.UserService;







@Controller
public class MainController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private UserService userService;
	
	
	
	
	
	@GetMapping("/classes")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {

			List<Course> allCourses = courseService.allCourses();
			User loggedUser = userService.findUserById((long) session.getAttribute("userId"));
			model.addAttribute("courses", allCourses);
			model.addAttribute("loggedUser", loggedUser);
			return "classes.jsp";
		} else {
			return "redirect:/";
		}

	}
	
	@GetMapping("/classes/new")
	public String renderNewForm(@ModelAttribute("newClass") Course newclass, HttpSession session) {
		if (session.getAttribute("userId") != null) {

			return "newCourse.jsp";
		} else {
			return "redirect:/";
		}

	}
	
	@PostMapping("/process/new")
	public String newClass(@Valid @ModelAttribute("newClass") Course newClass, BindingResult result,
			HttpSession session) {
		if (session.getAttribute("userId") != null) {
			if (result.hasErrors()) {
				return "newCourse.jsp";
			} else {
				//System.out.println(newProject.getId());
				courseService.createCourse((long) session.getAttribute("userId"), newClass);
				return "redirect:/classes";
			}

		} else {
			return "redirect:/";
		}

	}
	
	@GetMapping("/classes/{id}/edit")
	public String editCourse(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			Course course = courseService.findCourseById(id);
			model.addAttribute("course", course);
			return "editCourse.jsp";
		}

		return "redirect:/";
	}
	
	@PutMapping("/classes/{id}")
	public String editCourse(@PathVariable("id") Long id, @Valid @ModelAttribute("course") Course course,
			BindingResult result, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			if (result.hasErrors()) {
				return "editCourse.jsp";
			} else {
				courseService.updateCourse(id, course);
				return "redirect:/classes";
			}
		} else {
			return "redirect:/";
		}

	}
	
	@GetMapping("/classes/{id}")
	public String courseInfo(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			User loggedUser = userService.findUserById((long) session.getAttribute("userId"));
			Course course = courseService.findCourseById(id);
			model.addAttribute("course", course);
			model.addAttribute("loggedUser", loggedUser);
			return "courseDetails.jsp";
		} else {
			return "redirect:/";
		}

	}
	
	@DeleteMapping("/classes/{id}")
	public String deleteCourse(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			courseService.deleteCourse(id);
			return "redirect:/classes";
		} else {
			return "redirect:/";
		}

	}

}
