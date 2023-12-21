package com.openclassrooms.mypaybuddy.controller;

import com.openclassrooms.mypaybuddy.model.Transaction;
import com.openclassrooms.mypaybuddy.repository.CompteRepository;
import com.openclassrooms.mypaybuddy.repository.UserRepository;
import com.openclassrooms.mypaybuddy.service.TransfertDetailsImpl;
import com.openclassrooms.mypaybuddy.web.dto.TransfertDto;
import com.openclassrooms.mypaybuddy.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	TransfertDetailsImpl transfertDetails;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home() { return "index";}

	@RequestMapping(value = "/log", method = RequestMethod.GET)
	public String loginPage(Model model) {
		return "login";
	}

	@GetMapping("/transactions")
	public String listTransaction(Model model) {
		model.addAttribute("transactions", transfertDetails.getTransaction());
		return "transactions";
	}

	@GetMapping("/transactions/new")
	public String createStudentForm(Model model) {

		// create student object to hold student form data
	Transaction  transaction= new Transaction();
		model.addAttribute("transaction", transaction);
		return "create_transaction";
	}

	@PostMapping("/transactions")
	public String saveStudent(@ModelAttribute("transaction") Transaction transaction) {
		transfertDetails.saveTransfert(transaction);
		return "redirect:/transactions";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {

		// After user login successfully.
		String userName = principal.getName();

		System.out.println("User Name: " + userName);

		org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

		//String userInfo = WebUtils.toString(loginedUser);
		String userInfo = loginedUser.toString();

		model.addAttribute("userInfo", userInfo);

		return "userInfoPage";
	}
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			org.springframework.security.core.userdetails.User loginedUser = (User) ((Authentication) principal).getPrincipal();

			String userInfo = loginedUser.toString();

			model.addAttribute("userInfo", userInfo);

			String message = "Hi " + principal.getName() //
					+ "<br>Vous n'avais pas de permission pour acceder au page!";
			model.addAttribute("message", message);

		}
		return "403Page";
	}


	@GetMapping("/friend")
	public String showUser(Model model) {
		model.addAttribute("userList", userRepository.findAll());
		return "friend";
	}
	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public String processSendMoney(Model model, Transaction transaction) {

		System.out.println("Send Money::" + transaction.getMontant());

		try {
			transfertDetails.transfer(
					transaction.getCompte(), transaction.getCompte(), transaction.getMontant());
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Error: " + e.getMessage());
			return "/index";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/transfer", method = RequestMethod.GET)
	public String viewSendMoneyPage(Model model) {

		TransfertDto form = new TransfertDto("ndeye", 700);

		model.addAttribute("sendMoneyForm", form);

		return "index";
	}
}
