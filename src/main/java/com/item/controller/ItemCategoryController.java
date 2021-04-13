package com.item.controller;

import com.item.dto.CategoryDto;
import com.item.dto.ItemCategoryDto;
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

    /**
     * Description : Admin adding item category in db
     * @param adminId : this is for checking authorization
     * @param itemCategory : input itemCategory
     * @return : ItemCategory Dto
     */
    @PostMapping("/itemcategory/{adminId}")
    public ItemCategoryDto addItemCategory(@PathVariable("adminId") Integer adminId,
                                           @RequestBody ItemCategory itemCategory){

        return itemCategoryServices.addItemCategory(adminId,itemCategory);
    }

    /**
     * Description : Updating item category
     * @param adminId : this is for checking authorization
     * @param itemCategory : input itemCategory
     * @return ItemCategory Dto
     */
    @PutMapping("/itemcategory/{adminId}")
    public ItemCategoryDto updateItemCategory(@PathVariable("adminId") Integer adminId,
                                     @RequestBody ItemCategory itemCategory){
        return itemCategoryServices.updateItemCategory(adminId,itemCategory);
    }

    /**
     *  Description : to delete the Itemcategory
     * @param adminId : this is for checking authorization
     * @param itemCategoryId : to point which category to delete
     * @return : ItemCategory DTO
     */
    @DeleteMapping("/itemcategory/{adminId}/{itemCategoryId}")
    public ItemCategoryDto removeItemCategory(@PathVariable("adminId") Integer adminId,
                                     @PathVariable("itemCategoryId") Integer itemCategoryId){
        return itemCategoryServices.removeItemCategory(adminId,itemCategoryId);
    }

    /**
     * Description : get all itemCategories
     * @return list of itemCategory
     */
    @GetMapping("/itemcategory")
    public List<ItemCategory> getAllItemCategory(){
        return itemCategoryServices.getAllCategory();
    }

    /**Description:get all items by item category
     * @param itemCategoryId
     * @return list of all items
     */
    @GetMapping("/itemcategory/items/{itemCategoryId}")
    public List<Item> getItemsByItemCategory(@PathVariable("itemCategoryId") Integer itemCategoryId){
        return itemCategoryServices.getItemsByItemCategory(itemCategoryId);
    }

    /**
     * Description : get information for particular itemcategory by admin
     * @param adminId
     * @param itemCategoryId
     * @return itemCategory
     */
    @GetMapping("/itemcategory/{adminId}/{itemCategoryId}")
    public ItemCategory getItemCategory(@PathVariable("adminId") Integer adminId,
                                        @PathVariable("itemCategoryId") Integer itemCategoryId){
        return itemCategoryServices.getItemCategory(adminId,itemCategoryId);
    }

}
