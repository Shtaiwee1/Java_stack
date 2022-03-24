package com.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bookclub.models.Book;
import com.bookclub.models.User;
import com.bookclub.services.BookService;
import com.bookclub.services.UserService;




	
	@Controller
	public class BookController {
		@Autowired
		BookService bookService;
		@Autowired
		private UserService userService;
		
		
		@GetMapping("/books")
		public String main (HttpSession session, Model model) {
	        Long userId = (Long) session.getAttribute("user_id");
	        if (userId == null) {
	            return "redirect:/";
	        }else {
	        User thisUser = userService.findUserById(userId);
	        List<Book>books = bookService.allBooks();
	        model.addAttribute("thisUser", thisUser);
	        model.addAttribute("books", books);
	        return "books.jsp";
	        }
	    }
		
		@GetMapping("/books/new")
		public String newBook(@ModelAttribute("book") Book book, HttpSession session) {
			if (session.getAttribute("user_id") != null) {
				return "addBook.jsp";
			}else {

			return "redirect:/";
		}
		}
		
		@PostMapping("/books")
		public String register(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
			if (session.getAttribute("user_id") != null) {
				if (result.hasErrors()) {

					return "addBook.jsp";
				} else {
					bookService.createBook(book, (long) session.getAttribute("user_id"));
					return "redirect:/books";
				}
			} else {
				return "redirect:/";
			}

		}
		
		@GetMapping("/books/{id}")
		public String bookInfo(@PathVariable("id") Long id, Model model, HttpSession session) {
			if (session.getAttribute("user_id") != null) {
				Long user_id = (Long) session.getAttribute("user_id");
				Book book = bookService.findBookById(id);
				model.addAttribute("book", book);
				model.addAttribute("thisUserId", user_id);
				return "bookinfo.jsp";
			}

			return "redirect:/";
		}
		
		@GetMapping("/books/{id}/edit")
		public String editInfo(@PathVariable("id") Long id, Model model, HttpSession session) {
			if (session.getAttribute("user_id") != null) {
				Book book = bookService.findBookById(id);
				model.addAttribute("book", book);
				return "editBook.jsp";
			}

			return "redirect:/";
		}
		
		
		@PutMapping("/books/{id}")
		public String bookUpdate(@Valid @ModelAttribute("book") Book book,@PathVariable("id") Long id, Model model, HttpSession session, BindingResult result) {
			if (session.getAttribute("user_id") != null) {
				if (result.hasErrors()) {
					return "editBook.jsp";
				} else {
				 bookService.updateBook(book ,id);
				return "redirect:/books";
			}	
		}
			return "redirect:/";
    }
		
		
	}


