package com.beltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beltexam.models.Course;
import com.beltexam.models.User;


@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
	
	List<Course> findAll();

	//List<Course> findByMembersNotContaining(User user);

}
