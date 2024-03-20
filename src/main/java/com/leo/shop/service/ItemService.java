package com.leo.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.leo.shop.model.Item;
import com.leo.shop.model.User;
import com.leo.shop.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	public void saveItemn(String title, Integer price) throws Exception {
		Item item = new Item();
		//item.title = title;
		//item.price = price;
		int priceNum = price;
		int priceLength = (int)(Math.log10(priceNum)+1);
		if (title == null || price == null) {
			System.out.println("어딘가 빼먹고 안썼네");
			throw new Exception();
		} else if (title.length() > 40 || priceLength > 100){
			System.out.println("너무 길어");
			throw new Exception();
		} else {
			item.setTitle(title);
			item.setPrice(price);
			itemRepository.save(item);
			itemRepository.save(item);
		}
	}
	
	
	public void getDetail(@RequestParam("id") Long id, Model model) {
		Optional<Item> result = itemRepository.findById(id);
		if ( result.isPresent()) {
			System.out.println(result.get());
			model.addAttribute("data", result.get());
		}
	}
	
	
	public void getItems(Model model) {
		List<Item> result = itemRepository.findAll();
		//여기다가 겟 함수로 받아온거 저장해야됨
		model.addAttribute("items",result);
	}
	
	
	public void updateItems(Long id, String title, Integer price) throws Exception {
		Item item = new Item();
		int priceNum = price;
		int priceLength = (int)(Math.log10(priceNum)+1);
		if (title == null || price == null) {
			System.out.println("어딘가 빼먹고 안썼네");
			throw new Exception();
		} else if (title.length() > 40 || priceLength > 100){
			System.out.println("너무 길어");
			throw new Exception();
		} else {
			item.setTitle(title);
			item.setPrice(price);
			itemRepository.save(item);
			itemRepository.save(item);
		}
	}
	
	
	public void getUpdate(Model model, @RequestParam("id") Long id) {
		Optional<Item> result = itemRepository.findById(id);
		if ( result.isPresent() ) {
			model.addAttribute("data", result.get());
		}
	}
	

	
	
	
	
	
	
	
	
	
}
