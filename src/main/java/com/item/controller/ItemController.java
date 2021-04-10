package com.item.controller;
import com.item.dto.ItemDto;
import com.item.entity.*;

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
    public ItemDto addItem(@PathVariable("adminId") Integer adminId, @RequestBody Item item){
        return itemServices.addItem(adminId,item);
    }


    // update a item
    @PutMapping("/item/{adminId}")
    public ItemDto updateItem(@PathVariable("adminId") Integer adminId,@RequestBody Item item){
        return itemServices.updateItem(adminId,item);
    }

    // delete a particular item
    @DeleteMapping("/item/{adminId}/{itemId}")
    public ItemDto removeItem(@PathVariable("adminId") Integer adminId,
                             @PathVariable("itemId") Integer itemId) {
        return itemServices.removeItem(adminId,itemId);
    }

    // get a particular item
    @GetMapping("/item/{itemId}")
    public Item getItemById(@PathVariable("itemId") Integer itemId ){
        return itemServices.getItemById(itemId);
    }

}
