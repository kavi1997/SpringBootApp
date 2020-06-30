package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Dao.Repo;
import com.example.demo.model.Book;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class Restcontroller {
	
	@Autowired
	Repo repo;
	Book book;
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String book(Book bb) {
		repo.save(bb);
		return "index.html";
	}
private static final Logger logger = LoggerFactory.getLogger(Restcontroller.class);
	
	//Map to store employees, ideally we should use database
	Map<String, Book> bookData = new HashMap<String, Book>();
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> getDummyBook() {
		logger.info("Start getDummyBook");
		Book book = new Book();
	book.setBid("B00");
		book.setBname("Harry Potter");
		book.setAname("J.K.Rowling");
		book.setGenre("Fiction");
		bookData.put(book.getBid(), book);
		repo.save(book);
		return repo.findAll();
	}
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Book getBook(@PathVariable("id") String bid) {
		logger.info("Start getBook. ID="+bid);
		
		return repo.findBybid(bid);
	}
	
	@RequestMapping(value ="/book", method = RequestMethod.POST)
	public @ResponseBody Book createBook(@RequestBody Book book) {
		logger.info("Start createBook.");
		bookData.put(book.getBid(), book);
		repo.save(book);
		return book;
	}
	@RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
	public @ResponseBody Book deleteBook(@PathVariable("id") String bid,@RequestBody Book book) {
		logger.info("Start deleteBook.");
		bookData.put(book.getBid(), book);
		repo.findBybid(bid);
		repo.save(book);
		
		return book;
	}
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteBook1(@PathVariable("id") String bid) {
		logger.info("Start deleteBook.");
		bookData.remove(bid);
		repo.deleteById(bid);
		return "deleted successfully";
	}
	

}
