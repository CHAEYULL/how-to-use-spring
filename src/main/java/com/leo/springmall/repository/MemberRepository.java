package com.leo.springmall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.springmall.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	//소원 비는 곳
	//findBy컬럼명(데이터이름)
	//findAllBy컬럼명(컬럼이름) 하면 다 찾아와줌 다 찾을때는 List<>
	Optional<Member> findByUsername(String username);
}
