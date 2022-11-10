package com.example.Bookstore.web;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping("/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	@RequestMapping("/save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}

}
