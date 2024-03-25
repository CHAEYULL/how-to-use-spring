package com.leo.springmall.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.leo.springmall.model.Member;
import com.leo.springmall.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
@Autowired
private final MemberRepository memberRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //DB에서 username을 가진 유저를 찾아와서
	Optional<Member> result = this.memberRepository.findByUsername(username);
	if ( result.isEmpty() ) {
		throw new UsernameNotFoundException("아이디 없음");
	}
	Member user = result.get();
	List<GrantedAuthority> authorities = new ArrayList<>();
	authorities.add(new SimpleGrantedAuthority("일반유저"));
   return new User(user.getUsername(), user.getPassword(), authorities);
  }
} 