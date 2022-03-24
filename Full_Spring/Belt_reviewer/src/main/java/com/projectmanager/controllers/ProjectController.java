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


@Controller
public class ProjectController {
	@Autowired
	ProjectService projectService;
	@Autowired
	private UserService userService;
	@Autowired
	TaskService taskService;
	
	
	
	
	@GetMapping("/dashboard")
	public String dash(Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			User loggedInUser = userService.findUserById((long) session.getAttribute("user_id"));
			List<Project> availableProjects = projectService.unjoinedProjects((long) session.getAttribute("user_id"));
			//List<Project> joinedProjectsByLoggedUser = projectService.joinedProjects((long) session.getAttribute("user_id"));
			model.addAttribute("availabeProjects", availableProjects);
			model.addAttribute("loggedInUser", loggedInUser);
			return "dashboard.jsp";
		}

		return "redirect:/";
	}
	
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("project") Project project, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			return "addProject.jsp";
		}else {

		return "redirect:/";
	}
	}
	
	@PostMapping("/projects")
	public String create(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			if (result.hasErrors()) {

				return "addProject.jsp";
			} else {
				projectService.createProject(project, (long) session.getAttribute("user_id"));
				return "redirect:/dashboard";
			}
		} else {
			return "redirect:/";
		}

	}
	
	@GetMapping("/projects/edit/{id}")
	public String editInfo(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Project project = projectService.findProjectById(id);
			model.addAttribute("project", project);
			return "editProject.jsp";
		}

		return "redirect:/";
	}
	
	
	@PutMapping("/projects/{id}")
	public String projectUpdate(@PathVariable("id") Long id, @Valid @ModelAttribute("project") Project project,
			BindingResult result, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			if (result.hasErrors()) {
				System.out.println(result);
				return "editProject.jsp";
			} else {
			 projectService.updateProject(project ,id);
			return "redirect:/dashboard";
		}	
	}
		return "redirect:/";
}
	
	@GetMapping("/projects/{id}")
	public String projectInfo(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Long user_id = (Long) session.getAttribute("user_id");
			User loggedUser = userService.findUserById(user_id);
			Project project = projectService.findProjectById(id);
			model.addAttribute("project", project);
			model.addAttribute("loggedUser", loggedUser);
			return "projectinfo.jsp";
		}

		return "redirect:/";
	}
	
	
	@PutMapping("/projects/join/{id}")
	public String joinProject(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Long user_id = (Long) session.getAttribute("user_id");
			projectService.joinProject(id, user_id);
			return "redirect:/dashboard";
			
		}
		return "redirect:/";
	}
	
	@PutMapping("/projects/leave/{id}")
	public String unjoinProject(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Long user_id = (Long) session.getAttribute("user_id");
			projectService.unjoinProject(id, user_id);
			return "redirect:/dashboard";
			
		}
		return "redirect:/";
	}
	
	
	
	
	
	@DeleteMapping("/projects/{id}")
	public String deleteB(@PathVariable("id") Long id, HttpSession session) {
	if (session.getAttribute("user_id") != null) {
		projectService.deleteProject(id);
		return "redirect:/dashboard";
	}else {
		return "redirect:/";
	}
}
	@GetMapping("/projects/{id}/tasks")
	public String taskPage(@PathVariable("id") Long id, HttpSession session,@ModelAttribute("task") Task task , Model model) {
		if (session.getAttribute("user_id") != null) {
			Project project = projectService.findProjectById(id);
			model.addAttribute("project", project);
			return "addTask.jsp";
		}
		return"redirect:/";
		
	}
	
	@PostMapping("/projects/{id}/tasks")
	public String newTask(@PathVariable("id") Long id, @Valid @ModelAttribute("task") Task task,BindingResult result,Model model, HttpSession session ) {
		if (session.getAttribute("user_id") != null) {
			if (result.hasErrors()) {
				System.out.println(result);
				Project project = projectService.findProjectById(id);
				model.addAttribute("project", project);
				return "addTask.jsp";
			} else {
				Project project = projectService.findProjectById(id);
				Long user_id = (Long) session.getAttribute("user_id");
				taskService.createTask(task, user_id,id);
				model.addAttribute("project", project);
				return String.format( "redirect:/projects/%d/tasks" , id);
			}
			
		}else {
			return "redirect:/";
		}
		
	}

}
