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
	private ProjectRepository projectRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	 // returns all the projects
	 public List<Project> allProjects() {
	     return projectRepository.findAll();
	 }
	 // creates a new project
	 public void createProject(Project p , Long userLoggedInId) {
		 User loggedUser = userService.findUserById(userLoggedInId);
		 p.setTeamLead(loggedUser);
		 loggedUser.getProjects().add(p);
		 projectRepository.save(p);
		 userRepository.save(loggedUser);
	     
	 }
	 
	// retrieves an project
		public Project findProjectById(Long id) {
			Optional<Project> optionalProject = projectRepository.findById(id);
			if (optionalProject.isPresent()) {
				return optionalProject.get();
			} else {
				return null;
			}
		}
	 
	//Updates a project
	 public Project updateProject(Project project, Long targetProjectId) {
		Project p = this.findProjectById(targetProjectId);
			p.setTitle(project.getTitle());
			p.setDescription(project.getDescription());
			p.setDuedate(project.getDuedate());
			return projectRepository.save(p);
		}
	 
	//deletes a project
	 public void deleteProject(Long id) {
			Project project = this.findProjectById(id);
			projectRepository.delete(project);

		}
	 
	//projects addition
		 public List<Project> unjoinedProjects(Long userId) {
			 User user = userService.findUserById(userId);
				return projectRepository.findByMembersNotContaining(user);
			}

			//public List<Project> joinedProjects(Long UserId) {
				//User user = userService.findUserById(UserId);
				//return projectRepository.findByteamLead(user);
			//}

			//public void LeadProject(Long projectId, Long leaderId) {

				//User teamLead = userService.findUserById(leaderId);
				//Project project = this.findProjectById(projectId);

				//project.setBorrower(borrower);
				//projectRepository.save(project);

			//}

			//public void returnBorrowedBook(Long projectId) {

				//Project project = this.findProjectById(projectId);
				//project.setBorrower(null);
				//projectRepository.save(project);

			//}
	 
	 public void joinProject(Long projectId, Long userId) {
			Project project = this.findProjectById(projectId);
			User user = userService.findUserById(userId);
			project.getMembers().add(user);
			projectRepository.save(project);

		}

		public void unjoinProject(Long projectId, Long userId) {
			Project project = this.findProjectById(projectId);
			User user = userService.findUserById(userId);
			project.getMembers().remove(user);
			projectRepository.save(project);

		}			
		
}


