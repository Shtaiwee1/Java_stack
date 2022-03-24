package com.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookclub.models.Book;
import com.bookclub.models.User;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	 //A list of all books
	 List<Book> findAll();
	 //finds a specific book with a specific id
	 Optional<Book> findById(Long id);
	 
	//added to repository
	 
	 //This method gets all books that are not borrowed
		List<Book> findByBorrowerNull();

		//this method gets all the books borrowed by a specific user
		List<Book> findByBorrower(User borrower);
		 
	 

}
