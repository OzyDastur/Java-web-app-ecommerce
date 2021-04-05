package com.concordia.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.concordia.crud.dto.UserDTO;
import com.concordia.crud.service.impl.UserServiceImpl;

@Controller
public class UserController {

	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping(path="/register", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") UserDTO userDTO ) {
		userService.save(userDTO);
		return "redirect:/registration?success";
	}
	
	@RequestMapping(path="/registration", method=RequestMethod.GET)
	public String showRegistrationForm() {
		
		return "registration";
		
	}
	
	@ModelAttribute("user")
	public UserDTO userDTO() {
		return new UserDTO();
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String loginPage() {
		
		return "login";
		
	}
	@RequestMapping(path="/logout", method=RequestMethod.GET)
	public String logout() {
		
		
		
		return "login";
		
	}
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index() {
		
		return "index";
		
	}
	
	
	
	
}
