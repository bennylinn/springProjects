package com.oncewing.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oncewing.mvc.models.Book;
import com.oncewing.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	public Book findBook(long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		if (this.findBook(id) == null) {
			Book b = new Book(title, desc, lang, numOfPages);
			return bookRepository.save(b);
		} else {
			Book b = findBook(id);
			b.setTitle(title);
			b.setDescription(desc);
			b.setLanguage(lang);
			b.setNumberOfPages(numOfPages);
			return bookRepository.save(b);
		}
	}
	
	public Book deleteBook(Long id) {
		Book b = findBook(id);
		if(b == null) {
			return null;
		} else {
			bookRepository.deleteById(id);
			return b;
		}
	}
}
