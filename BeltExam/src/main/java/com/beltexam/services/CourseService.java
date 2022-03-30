package com.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beltexam.models.Course;
import com.beltexam.models.User;
import com.beltexam.repositories.CourseRepository;
import com.beltexam.repositories.UserRepository;



@Service
public class CourseService {
	
	
	
		
		@Autowired
		private CourseRepository courseRepository;
		@Autowired
		private UserService userService;
		@Autowired
		private UserRepository userRepository;
		
		 // returns all the Courses
		 public List<Course> allCourses() {
		     return courseRepository.findAll();
		 }
		 // creates a new Course
		 public void createCourse( Long userLoggedInId, Course c) {
			 User loggedUser = userService.findUserById(userLoggedInId);
			 c.setInstructor(loggedUser);
			 loggedUser.getCourses().add(c);
			 courseRepository.save(c);
			 userRepository.save(loggedUser);
		     
		 }
		 
		// retrieves an course
			public Course findCourseById(Long id) {
				Optional<Course> optionalCourse = courseRepository.findById(id);
				if (optionalCourse.isPresent()) {
					return optionalCourse.get();
				} else {
					return null;
				}
			}
		 
		//Updates a course
		 public Course updateCourse( Long targetCourseId , Course course) {
			 Course p = this.findCourseById(targetCourseId);
				p.setName(course.getName());
				p.setDay(course.getDay());
				p.setPrice(course.getPrice());
				p.setDescription(course.getDescription());
				return courseRepository.save(p);
			}
		 
		//deletes a Course
		 public void deleteCourse(Long id) {
				Course course = this.findCourseById(id);
				courseRepository.delete(course);

			}

}
