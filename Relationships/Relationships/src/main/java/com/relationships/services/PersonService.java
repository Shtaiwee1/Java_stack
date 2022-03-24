package com.relationships.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.relationships.models.Person;
import com.relationships.repositories.PersonRepository;


@Service
public class PersonService {
		
		// adding the book repository as a dependency
		private final PersonRepository personRepository;
		 
		 public PersonService(PersonRepository personRepository) {
		     this.personRepository = personRepository;
		 }
		
		// retrieves a book
		 public Person findPerson(Long id) {
		     Optional<Person> optionalPerson = personRepository.findById(id);
		     if(optionalPerson.isPresent()) {
		         return optionalPerson.get();
		     } else {
		         return null;
		     }
		 }

	}

