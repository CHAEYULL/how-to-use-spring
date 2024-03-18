package com.leo.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leo.shop.model.Item;
import com.leo.shop.repository.ItemRepository;
import com.leo.shop.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {
	private final ItemRepository itemRepository;// 얘가 데이터들어있는 전체 통이라고 생각하면됨 꺼낼때도 여기서 꺼내고 추가할때도 여기다가 추가하는거임
	private final ItemService itemService;
	
//	@Autowired //이렇게 쓰나
//	public ItemController(ItemRepository itemRepository) {
//		this.itemRepository = itemRepository;
//	}

	@GetMapping("/")
	String home() {
		return "index.html";
	}
	
	@GetMapping("/list")
	String list(Model model) {
		List<Item> result = itemRepository.findAll();
		//여기다가 겟 함수로 받아온거 저장해야됨
		model.addAttribute("items",result);
		return "list.html";
	}
	
	@GetMapping("/write")
	String write() {
		return "write.html";
	}
	@GetMapping("/detail/{id}")
	String detail(@PathVariable("id") Long id, Model model) {
		itemService.getDetail(id, model);
		return "detail.html";

		
	}
	@PostMapping("/add")
	String addPost(@RequestParam(name="title") String title,
					 @RequestParam(name="price") Integer price) {
		System.out.println(title);
		System.out.println(price);
		itemService.saveItemn(title, price);
		return "redirect:/list";
	}
	
}
