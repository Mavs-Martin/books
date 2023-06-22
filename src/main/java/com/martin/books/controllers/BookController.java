package com.martin.books.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.martin.books.models.Book;
import com.martin.books.services.BookService;
import com.martin.books.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
	private final BookService bookServ;
	private final UserService userServ;

	public BookController(BookService bookServ, UserService userServ) {
		this.bookServ = bookServ;
		this.userServ = userServ;
	}

	@GetMapping("/create")
	public String createCar(@ModelAttribute("book") Book book) {
		return "book/create.jsp";
	}

	@PostMapping("/process/create")
	public String processCreateBook(@Valid @ModelAttribute("book") Book book, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "book/create.jsp";
		}
		book.setSeller(userServ.getUser((Long) session.getAttribute("user_id")));
		bookServ.create(book);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookServ.getOne(id));
		return "book/edit.jsp";
	}

	@PutMapping("process/edit/{id}")
	public String processEditBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "book/edit.jsp";
		}
		bookServ.update(book);
		return "redirect:/";

	}
	
	@GetMapping("/{id}")
	public String displayBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookServ.getOne(id));
		return "book/displayOne.jsp";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookServ.delete(id);
		return "redirect:/";
	}
}
