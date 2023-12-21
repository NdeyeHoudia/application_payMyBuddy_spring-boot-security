package com.openclassrooms.mypaybuddy.controller;

import com.openclassrooms.mypaybuddy.model.User;
import com.openclassrooms.mypaybuddy.repository.UserRepository;
import com.openclassrooms.mypaybuddy.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/msg")
	public String showUser(Model model) {
		model.addAttribute("userList", userRepository.findAll());
		model.addAttribute("user", new User());


	//	userRepository.fi
		return "index";
	}
	/*@PostMapping("/friend")
	public String getUser(@ModelAttribute User newUser) {
		User friend = new User(newUser.getUsername(), newUser.getEmail(), newUser.getPassword(),newUser.getRoles());
		userRepository.save(friend);
		return "redirect:/friend";
	}*/
}
