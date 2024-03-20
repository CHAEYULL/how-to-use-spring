package com.leo.shop.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.leo.shop.repository.UserRepository;

import lombok.RequiredArgsConstructor;

//@Service
//@RequiredArgsConstructor
//public class MyUserDetailsService implements UserDetailsService {
//	private final UserRepository userRepository;
//	@Override
////	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////			userRepository.findByUsername(username);
////		//return
////	}
//}
