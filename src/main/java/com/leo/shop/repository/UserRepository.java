package com.leo.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.shop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//findBy컬럼명(어쩌구) 
	Optional<User> findByUsername(String username);
	// 다 찾을거면
	//List<User> findAllUsername(String username);
}
