package com.leo.springmall.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leo.springmall.model.Item;
import com.leo.springmall.repository.ItemRepository;
import com.leo.springmall.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {
	@Autowired
	private final ItemRepository itemRepository;
	@Autowired
	private final ItemService itemService;
	@GetMapping("/list")
	String list(Model model) {
		this.itemService.getItemService(model);
		return "list.html";
	}
	@GetMapping("/detail/{id}")
	String detail(@PathVariable("id") Long id, Model model) {
		this.itemService.getItemDetailService(id, model);
		return "detail.html";
	}
	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id, Model model) {
		this.itemService.getItemEditService(id, model);
		return "edit.html";
	}
	@GetMapping("/write")
	String write() {
		return "write.html";
	}
	@PostMapping("/add")
	String addItem(@RequestParam(name="title") String title,
					 @RequestParam(name="price") Integer price) throws Exception {
		this.itemService.addItemService(title, price);
		return "redirect:/list";
	}
	@PostMapping("/update")
	String itemEdit(@RequestParam(name="id") Long id,
					  @RequestParam(name="title") String title,
					  @RequestParam(name="price") Integer price) {
		this.itemService.itemEditService(id, title, price);
		return "redirect:/list";
	}
	@DeleteMapping("/delete")
	ResponseEntity<String>  deleteItem(@RequestParam("docid") Long id) {
		itemRepository.deleteById(id);
		return ResponseEntity.status(200).body("삭제완료");
	}
}
