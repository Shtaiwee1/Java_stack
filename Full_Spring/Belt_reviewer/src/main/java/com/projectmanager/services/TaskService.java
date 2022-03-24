package com.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanager.models.Project;
import com.projectmanager.models.Task;
import com.projectmanager.models.User;
import com.projectmanager.repositories.ProjectRepository;
import com.projectmanager.repositories.TaskRepository;
import com.projectmanager.repositories.UserRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectRepository projectRepository;
	
	
	 // returns all the Tasks
	 public List<Task> allTasks() {
	     return taskRepository.findAll();
	 }
	 // creates a new Task
	 public void createTask(Task t , Long userLoggedInId ,Long projectId) {
		 User loggedUser = userService.findUserById(userLoggedInId);
		 Project project = projectService.findProjectById(projectId);
		 t.setId(null);
		 t.setUser(loggedUser);
		 t.setProject(project);
		 taskRepository.save(t);
		
	     
	 }
	 
	// retrieves an Task
		public Task findTaskById(Long id) {
			Optional<Task> optionalTask = taskRepository.findById(id);
			if (optionalTask.isPresent()) {
				return optionalTask.get();
			} else {
				return null;
			}
		}
	 
	//Updates a Task
	 public Task updateTask(Task task, Long targetTaskId) {
		Task p = this.findTaskById(targetTaskId);
			p.setTicket(task.getTicket());
			return taskRepository.save(p);
		}
	 
	//deletes a project
	 public void deleteTask(Long id) {
			Task task = this.findTaskById(id);
			taskRepository.delete(task);

		}
}
