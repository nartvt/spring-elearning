package com.elearning.program.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin")
public class AdminAuthenticationController {

	@GetMapping("login")
	public String login(@RequestParam(required = false) String error, Model model) {
		if (error != null && !error.isEmpty()) {
			model.addAttribute("message", "Account or password is wrong ");
		}
		return "adminLogin";
	}
	@PostMapping("/login")
	public String loginProcess( Model model) {
		
		return "adminLogin";
	}
}