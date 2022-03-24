package com.projectmanager.controllers;

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

import com.projectmanager.models.Project;
import com.projectmanager.models.Task;
import com.projectmanager.models.User;
import com.projectmanager.services.ProjectService;
import com.projectmanager.services.TaskService;
import com.projectmanager.services.UserService;

//.. don't forget to include all your imports!

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projService;

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;

	@GetMapping("/dashboard")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {

			List<Project> projectsNotPartOf = projService.projectsNotPartOf((long) session.getAttribute("userId"));
			User loggedUser = userService.findUserById((long) session.getAttribute("userId"));
			model.addAttribute("projectsNotPartOf", projectsNotPartOf);
			model.addAttribute("loggedUser", loggedUser);
			return "dashboard.jsp";
		} else {
			return "redirect:/";
		}

	}

	@GetMapping("/projects/{id}")
	public String index(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			User loggedUser = userService.findUserById((long) session.getAttribute("userId"));
			Project project = projService.findProjectById(id);
			model.addAttribute("project", project);
			model.addAttribute("loggedUser", loggedUser);
			return "projectDetails.jsp";
		} else {
			return "redirect:/";
		}

	}

	@GetMapping("/projects/{id}/tasks")
	public String tasks(@PathVariable("id") Long id, @ModelAttribute("newTask") Task newTask, Model model,
			HttpSession session) {
		if (session.getAttribute("userId") != null) {
			Project project = projService.findProjectById(id);
			model.addAttribute("project", project);

			return "projectTasks.jsp";
		} else {
			return "redirect:/";
		}

	}

	@PostMapping("/projects/{id}/tasks")
	public String addTask(@PathVariable("id") Long id, @Valid @ModelAttribute("newTask") Task newTask,
			BindingResult result, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			if (result.hasErrors()) {
				Project project = projService.findProjectById(id);
				model.addAttribute("project", project);
				return "projectTasks.jsp";
			} else {
				taskService.createTask(newTask, id, (long) session.getAttribute("userId"));
				return String.format("redirect:/projects/%d/tasks", id);
			}

		} else {
			return "redirect:/";
		}

	}

	@GetMapping("/projects/new")
	public String renderNewForm(@ModelAttribute("newProject") Project newProject, HttpSession session) {
		if (session.getAttribute("userId") != null) {

			return "newProject.jsp";
		} else {
			return "redirect:/";
		}

	}

	@PostMapping("/projects")
	public String newProject(@Valid @ModelAttribute("newProject") Project newProject, BindingResult result,
			HttpSession session) {
		if (session.getAttribute("userId") != null) {
			if (result.hasErrors()) {
				return "newProject.jsp";
			} else {
				System.out.println(newProject.getId());
				projService.createProject((long) session.getAttribute("userId"), newProject);
				return "redirect:/dashboard";
			}

		} else {
			return "redirect:/";
		}

	}

	@GetMapping("/projects/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			Project project = projService.findProjectById(id);
			model.addAttribute("project", project);
			return "editProject.jsp";
		}

		return "redirect:/";
	}

	@PutMapping("/projects/{id}")
	public String editBook(@PathVariable("id") Long id, @Valid @ModelAttribute("project") Project project,
			BindingResult result, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			if (result.hasErrors()) {

				return "editProject.jsp";
			} else {
				projService.updateProject(id, project);
				return "redirect:/dashboard";
			}
		} else {
			return "redirect:/";
		}

	}

	@PutMapping("/projects/{id}/join")
	public String join(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			projService.joinProject(id, (long) session.getAttribute("userId"));
			return "redirect:/dashboard";
		} else {
			return "redirect:/";
		}

	}

	@PutMapping("/projects/{id}/leave")
	public String leave(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			projService.leaveProject(id, (long) session.getAttribute("userId"));
			return "redirect:/dashboard";
		} else {
			return "redirect:/";
		}

	}

	@DeleteMapping("/projects/{id}")
	public String deleteProject(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			projService.deleteProject(id);
			return "redirect:/dashboard";
		} else {
			return "redirect:/";
		}

	}
	
	

}