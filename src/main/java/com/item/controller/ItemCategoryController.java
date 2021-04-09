package com.item.controller;

import com.item.entity.Category;
import com.item.entity.Item;
import com.item.entity.ItemCategory;
import com.item.services.ItemCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemCategoryController {
    @Autowired
    ItemCategoryServices itemCategoryServices;

    /*Admin adding item category in db using subcategoryId*/
    @PostMapping("/itemcategory/{adminId}")
    public String addItemCategory(@PathVariable("adminId") Integer adminId,
                                  @RequestBody ItemCategory itemCategory){

        return itemCategoryServices.addItemCategory(adminId,itemCategory);
    }

    /**Updating item category**/
    @PutMapping("/itemcategory/{adminId}")
    public String updateItemCategory(@PathVariable("adminId") Integer adminId,
                                     @RequestBody ItemCategory itemCategory){
        return itemCategoryServices.updateItemCategory(adminId,itemCategory);
    }

    @DeleteMapping("/itemcategory/{adminId}/{itemCategoryId}")
    public String removeItemCategory(@PathVariable("adminId") Integer adminId,
                                     @PathVariable("itemCategoryId") Integer itemCategoryId){
        return itemCategoryServices.removeItemCategory(adminId,itemCategoryId);
    }

    /**get all items by item category*/
    @GetMapping("/itemcategory/{itemCategoryId}")
    public List<Item> getItemsByItemCategory(@PathVariable("itemCategoryId") Integer itemCategoryId){
        return itemCategoryServices.getItemsByItemCategory(itemCategoryId);
    }

    //get information for particular itemcategory by admin
    @GetMapping("/itemcategory/{adminId}/{itemCategoryId}")
    public ItemCategory getItemCategory(@PathVariable("adminId") Integer adminId,
                                          @PathVariable("itemCategoryId") Integer itemCategoryId){
        return itemCategoryServices.getItemCategory(adminId,itemCategoryId);
    }

}
