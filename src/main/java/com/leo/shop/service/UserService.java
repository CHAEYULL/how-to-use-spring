package com.leo.shop.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.leo.shop.model.User;
import com.leo.shop.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	
	public void userRegister(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		String realPwd = user.getPassword();
		new BCryptPasswordEncoder().encode(realPwd);
		user.setPassword(realPwd);
		userRepository.save(user);
	}
}
