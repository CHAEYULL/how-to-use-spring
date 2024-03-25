package com.leo.springmall.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.leo.springmall.model.Member;
import com.leo.springmall.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	@Autowired
	private final MemberRepository memberRepository;
	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	
	public void postRegisterService(Map<String, String> formData) throws Exception{
		Member member = new Member();
		if (formData.get("username") == null || formData.get("password") == null) {
			System.out.print("어딘가 안썼네");
			throw new Exception();
		} else if (formData.get("username").length() < 3 || formData.get("password").length() < 3) {
			System.out.println("너무 짧아");
			throw new Exception();
		} else {
			member.setUsername(formData.get("username"));
			member.setDisplayName(formData.get("displayName"));
			String hash = this.passwordEncoder.encode(formData.get("password"));
			member.setPassword(hash);
			this.memberRepository.save(member);
		}
		//아이디 겹치는게 있으면 막아줘 @
	}
	
	
	
	
}
