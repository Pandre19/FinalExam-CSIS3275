package com.example.finalexam.web;
import com.example.finalexam.entities.Items;
import com.example.finalexam.repositories.ItemsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

//---------------------------------------------------------
//---------------------------------------------------------
//Github REPO Link
//https://github.com/Pandre19/FinalExam-CSIS3275
//---------------------------------------------------------
//---------------------------------------------------------

@Controller
public class ItemsController {

    private ItemsRepository itemsRepository;

    public ItemsController(ItemsRepository itemsRepository){
        this.itemsRepository = itemsRepository;
    }

    @GetMapping(path = "/items")
    public String items(Model model) {
        List<Items> items = itemsRepository.getAllItems();

        model.addAttribute("items", items);
        return "itemsPage";
    }

    @GetMapping(path = "/editItem")
    public String editItems(Model model) {
        return "editItemPage";
    }

    @PostMapping(path="/add")
    public void addItem(Model model, @RequestParam Integer recno,
                        @RequestParam String icode,
                        @RequestParam Double qty, @RequestParam Date dot) {
        if(recno == 0){
            //Send recno cannot be 0
        } else if(icode.equals("option")){
            //Ask to select an option
        } else if(qty == 0.0) {
            //Ask to put a qty
        } else {
            itemsRepository.createItem(recno, icode, qty, dot);
        }
    }
}
