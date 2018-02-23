package com.nagappans.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String homepage() {
		System.out.println("index html get method");
		return "index.html";
	}
	
}