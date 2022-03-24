package com.projectmanager.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projectmanager.models.Project;
import com.projectmanager.models.User;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	 //A list of all books
	 List<Project> findAll();
	 //finds a specific book with a specific id
	 Optional<Project> findProjectById(Long id);
	 
	//added to repository
	 
	 //This method gets all books that are not joined
		//List<Project> findByteamLeadNull();

		//this method gets all the projects joined by a specific user
		List<Project> findByteamLead(User teamLead);
		 
		List<Project> findByMembersNotContaining(User user);

}

