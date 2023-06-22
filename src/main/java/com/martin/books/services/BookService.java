package com.martin.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.martin.books.models.Book;
import com.martin.books.repositories.BookRepository;

@Service
public class BookService {

	private static BookRepository BookRepo;

	public BookService(BookRepository BookRepo) {
		this.BookRepo = BookRepo;
	}

	public Book getOne(Long id) {
		Optional<Book> Book = BookRepo.findById(id);
		return Book.isPresent() ? Book.get() : null;
	}

	public List<Book> getAll() {
		return (List<Book>) BookRepo.findAll();
	}

	public Book create(Book dojo) {
		return BookRepo.save(dojo);
	}

	public Book update(Book dojo) {
		return BookRepo.save(dojo);
	}

	public void delete(Long id) {
		BookRepo.deleteById(id);
	}

}
