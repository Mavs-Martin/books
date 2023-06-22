package com.martin.books.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.martin.books.services.BookService;
import com.martin.books.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	private final UserService userServ;
	private final BookService bookServ;
	public HomeController(UserService userServ, BookService bookServ) {
		this.userServ = userServ;
		this.bookServ = bookServ;
	}
	
	
	@GetMapping("/")
	public String home(HttpSession session, Model model){
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/register";
		}
		model.addAttribute("allBooks", bookServ.getAll());
		return "main/dashboard.jsp";
		
	}
	

}
