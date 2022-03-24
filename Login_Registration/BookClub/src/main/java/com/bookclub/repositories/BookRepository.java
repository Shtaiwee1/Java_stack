package com.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookclub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	 //A list of all books
	 List<Book> findAll();
	 //finds a specific book with a specific id
	 Optional<Book> findById(Long id);
	 
	 
	 

}
