package com.openclassrooms.mypaybuddy.controller;

import com.openclassrooms.mypaybuddy.model.Transaction;
import com.openclassrooms.mypaybuddy.model.User;
import com.openclassrooms.mypaybuddy.repository.CompteRepository;
import com.openclassrooms.mypaybuddy.repository.UserRepository;
import com.openclassrooms.mypaybuddy.service.TransfertDetailsImpl;
import com.openclassrooms.mypaybuddy.service.UserServiceImpl;
import com.openclassrooms.mypaybuddy.web.dto.TransfertDto;
import com.openclassrooms.mypaybuddy.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	TransfertDetailsImpl transfertDetails;
	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home() { return "index";}

	@GetMapping("/registration")
	public String listConnection(Model model) {
		model.addAttribute("registration", userService.getAllUsers());
		return "registration";
	}
	@PostMapping("/registration")
	public String addConnection (@ModelAttribute("registrations") User friend, String username) {
		com.openclassrooms.mypaybuddy.model.User user = userRepository.findByUsername(username);
		//model.addAttribute(user.getListFriends());
		userService.addConnexion(user,friend);
		return "redirect:/registration";
	}

}
