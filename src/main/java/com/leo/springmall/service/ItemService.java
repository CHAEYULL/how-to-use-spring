package com.leo.springmall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.leo.springmall.model.Item;
import com.leo.springmall.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
    @Autowired
    private final ItemRepository itemRepository;

    public void getItemService(Model model) {
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
    }

    public void getItemDetailService(@RequestParam("id") Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        model.addAttribute("data", result.get());
    }

    public void getItemEditService(@RequestParam("id") Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        model.addAttribute("data", result.get());
    }

    public void addItemService(@RequestParam(name="title") String title,
                               @RequestParam(name="price") Integer price) throws Exception {
        Item item = new Item();
        int priceNum = price;
        int priceLength = (int)(Math.log10(priceNum)+1);
        if (title == null || price == null) {
            System.out.print("어딘가 공백이 있음");
            throw new Exception();
        } else if (title.length() > 40 || priceLength > 100){
            throw new Exception();
        } else {
            item.setTitle(title);
            item.setPrice(price);
            itemRepository.save(item);
        }
    }

    public void itemEditService(@RequestParam(name="id") Long id,
                                @RequestParam(name="title") String title,
                                @RequestParam(name="price") Integer price) {
        Item item = new Item();
        item.setId(id);
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }
}
