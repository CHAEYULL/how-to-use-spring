package com.leo.shop.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leo.shop.model.User;
import com.leo.shop.repository.ItemRepository;
import com.leo.shop.repository.UserRepository;
import com.leo.shop.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserRepository userRepository;
	
	@GetMapping("/register")
	String register() {
		return "register.html";
	}
	@GetMapping("/login")
	String login() {
		return "login.html";
	}
	@PostMapping("/register")
	String registerUser(@RequestParam(name="username") String username,
						   @RequestParam(name="password") String password) {
		User user = new User();
		user.setUsername(username);
		String hash = new BCryptPasswordEncoder().encode(password);
		user.setPassword(hash);
		userRepository.save(user);
		return "redirect:/list";
	}
}
