package com.elearning.program.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

	@GetMapping("account/login")
	public String login(@RequestParam(required = false) String error,
			Model model) {
		if(error != null && error.equals("true")) {
			model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
		}
		return "adminLogin";
	}
}
