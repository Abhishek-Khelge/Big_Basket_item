package com.item.controller;

import com.item.entity.Category;
import com.item.entity.Item;
import com.item.entity.SubCategory;
import com.item.services.CategoryServices;
import com.item.services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemServices itemServices;

    // add a item
    @PostMapping("/item/{adminId}")
    public String addItem(@PathVariable("adminId") Integer adminId,@RequestBody Item item){
        return itemServices.addItem(adminId,item);
    }


    // update a item
    @PutMapping("/item/{adminId}")
    public String updateItem(@PathVariable("adminId") Integer adminId,@RequestBody Item item){
        return itemServices.updateItem(adminId,item);
    }

    // delete a particular item
    @DeleteMapping("/item/{adminId}/{itemId}")
    public String removeItem(@PathVariable("adminId") Integer adminId,
                             @PathVariable("itemId") Integer itemId) {
        return itemServices.removeItem(adminId,itemId);
    }

    // get a particular item
    @GetMapping("/item/{itemId}")
    public Item getItemById(@PathVariable("itemId") Integer itemId ){
        return itemServices.getItemById(itemId);
    }
}
