package com.leo.springmall.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.springmall.model.Member;
import com.leo.springmall.repository.MemberRepository;
import com.leo.springmall.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	@Autowired
	private final MemberRepository memberRepository;
	@Autowired
	private final MemberService memberService;
	//var hash = new BCryptPasswordEncoder().encode(null);
	@GetMapping("/register")
	String getRegister() {
		return "register.html";
	}
	@GetMapping("/login")
	String getLogin() {
		return "login.html";
	}
	@GetMapping("/mypage")
	String getMypage(Authentication auth) {
		System.out.println(auth.getAuthorities().contains(
				new SimpleGrantedAuthority("일반유저")
		));
		
		System.out.println(auth.getName());
		System.out.println(auth.isAuthenticated());
		return "mypage.html";
	}
	@PostMapping("/register")
	@ResponseBody
	ResponseEntity<String> postRegister(@RequestBody Map<String, String> formData) throws Exception {
		memberService.postRegisterService(formData);
		return ResponseEntity.status(200).body("회원가입 완료");
	}
}
