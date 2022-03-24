package com.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.models.Book;
import com.bookclub.models.User;
import com.bookclub.repositories.BookRepository;



@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserService userService;
	
	 // returns all the Books
	 public List<Book> allBooks() {
	     return bookRepository.findAll();
	 }
	 // create a new book
	 public Book createBook(Book b , Long userLoggedInId) {
		 User loggedUser = userService.findUserById(userLoggedInId);
		 b.setUser(loggedUser);
	     return bookRepository.save(b);
	 }
	 
	// retrieves an book
		public Book findBookById(Long id) {
			Optional<Book> optionalBook = bookRepository.findById(id);
			if (optionalBook.isPresent()) {
				return optionalBook.get();
			} else {
				return null;
			}
		}
	 
	//Updates an book
	 public Book updateBook(Book book, Long targetBookId) {
		Book b = findBookById(targetBookId);
			b.setTitle(book.getTitle());
			b.setAuthor(book.getAuthor());
			b.setThoughts(book.getThoughts());
			return bookRepository.save(b);
		}
	 
	//deletes an book
	 public void deleteBook(Long id) {
			Book book = this.findBookById(id);
			bookRepository.delete(book);

		}
	 
	//borrowed books addition
		 public List<Book> availableBooks() {
				return bookRepository.findByBorrowerNull();
			}

			public List<Book> borrowedBooks(Long borrowerId) {
				User borrower = userService.findUserById(borrowerId);
				return bookRepository.findByBorrower(borrower);
			}

			public void borrowBook(Long bookId, Long borrowerId) {

				User borrower = userService.findUserById(borrowerId);
				Book book = this.findBookById(bookId);

				book.setBorrower(borrower);
				bookRepository.save(book);

			}

			public void returnBorrowedBook(Long bookId) {

				Book book = this.findBookById(bookId);
				book.setBorrower(null);
				bookRepository.save(book);

			}
				
			}


			
		


