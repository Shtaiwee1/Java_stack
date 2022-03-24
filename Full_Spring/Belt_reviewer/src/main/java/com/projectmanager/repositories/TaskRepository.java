package com.projectmanager.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.projectmanager.models.Task;


@Repository
public interface TaskRepository extends CrudRepository<Task, Long>  {
	
		 //A list of all books
		 List<Task> findAll();
		 //finds a specific book with a specific id
		 Optional<Task> findTaskById(Long id);
		 

}
