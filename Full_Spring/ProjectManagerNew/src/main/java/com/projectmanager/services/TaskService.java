package com.projectmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanager.models.Project;
import com.projectmanager.models.Task;
import com.projectmanager.models.User;
import com.projectmanager.repositories.TaskRepository;


@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepo;

	@Autowired
	private ProjectService projServ;

	@Autowired
	private UserService userServ;

	public void createTask(Task newTask, Long projId, Long userId) {
		Project project = projServ.findProjectById(projId);
		User user = userServ.findUserById(userId);
		newTask.setId(null);
		newTask.setUser(user);
		newTask.setProject(project);
		taskRepo.save(newTask);
	}

}
