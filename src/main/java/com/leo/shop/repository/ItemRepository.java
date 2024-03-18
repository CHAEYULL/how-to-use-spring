package com.leo.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.shop.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
