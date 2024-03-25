package com.leo.springmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.springmall.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
