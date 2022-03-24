package com.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projectmanager.models.Project;
import com.projectmanager.models.User;



//.. imports .. //

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	List<Project> findAll();

	List<Project> findByMembersNotContaining(User user);
}