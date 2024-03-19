package com.leo.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		itemService.getItems(model);
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
	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id, Model model) {
		itemService.getUpdate(model, id);
			return "edit.html";
	}
	@PostMapping("/update")
	String updatePost(@RequestParam(name="id") Long id,
						@RequestParam(name="title") String title,
						@RequestParam(name="price") Integer price) {
		//update 으로 포스트 요청을 받아서 데이터 베이스에 있는걸 업데이트 해주는거임 저장이 아니라
			itemService.updateItems(id, title, price);
			return "redirect:/list";
	}
	@PostMapping("/add")
	String addPost(@RequestParam(name="title") String title,
					 @RequestParam(name="price") Integer price) {
		itemService.saveItemn(title, price);
		return "redirect:/list";
	}
	@DeleteMapping("/delete")
	ResponseEntity<String> deletePost(@RequestParam("docid") Long docid) {
		itemRepository.deleteById(docid);
		return ResponseEntity.status(200).body("삭제완료");
	}
	
}
