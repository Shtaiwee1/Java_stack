package com.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	
		// this method retrieves all the people from the database
	    List<Person> findAll();

}
