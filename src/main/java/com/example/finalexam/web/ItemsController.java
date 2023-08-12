package com.example.finalexam.web;
import com.example.finalexam.entities.Items;
import com.example.finalexam.repositories.ItemsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ItemsController {

    private ItemsRepository itemsRepository;

    public ItemsController(ItemsRepository itemsRepository){
        this.itemsRepository = itemsRepository;
    }

    @GetMapping(path = "/items")
    public String students(Model model) {
        List<Items> items = itemsRepository.getAllItems();

        model.addAttribute("items", items);
        return "itemsPage";
    }
}
