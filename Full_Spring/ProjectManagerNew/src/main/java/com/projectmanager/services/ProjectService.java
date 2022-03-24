package com.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanager.models.Project;
import com.projectmanager.models.User;
import com.projectmanager.repositories.ProjectRepository;
import com.projectmanager.repositories.UserRepository;



@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserService userServ;

	public Project findProjectById(Long Id) {
		Optional<Project> p = projRepo.findById(Id);
		if (p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}

	public List<Project> projectsNotPartOf(Long userId) {
		User user = userServ.findUserById(userId);
		return projRepo.findByMembersNotContaining(user);

	}

	public void createProject(Long userId, Project newProject) {
		User user = userServ.findUserById(userId);
		newProject.setCreator(user);
		user.getProjects().add(newProject);
		projRepo.save(newProject);
		userRepo.save(user);

	}

	public void updateProject(Long projId, Project updatedProject) {
		Project project = this.findProjectById(projId);
		project.setTitle(updatedProject.getTitle());
		project.setDescription(updatedProject.getDescription());
		project.setDueDate(updatedProject.getDueDate());
		projRepo.save(project);

	}

	public void joinProject(Long projId, Long userId) {
		Project project = this.findProjectById(projId);
		User user = userServ.findUserById(userId);
		project.getMembers().add(user);
		projRepo.save(project);

	}

	public void leaveProject(Long projId, Long userId) {
		Project project = this.findProjectById(projId);
		User user = userServ.findUserById(userId);
		project.getMembers().remove(user);
		projRepo.save(project);

	}

	public void deleteProject(Long projId) {
		Project project = this.findProjectById(projId);
		projRepo.delete(project);

	}

}
