package com.item.services;

import com.item.dto.CategoryDto;
import com.item.dto.ItemCategoryDto;
import com.item.entity.Category;
import com.item.entity.Item;
import com.item.entity.ItemCategory;
import com.item.repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemCategoryServices {
    @Autowired
    ItemCategoryRepository itemCategoryRepository;
    @Autowired
    ItemServices itemServices;


    public ItemCategoryDto addItemCategory(Integer adminId, ItemCategory itemCategory) {
        //verify admin
        ItemCategory itemCategory1 = itemCategoryRepository.save(itemCategory);
        ItemCategoryDto itemCategoryDto = new ItemCategoryDto();
        itemCategoryDto.setItemCategory(itemCategory1);
        itemCategoryDto.setStatus("ItemCategory successfully added.");
        return itemCategoryDto;
    }

    public ItemCategoryDto updateItemCategory(Integer adminId, ItemCategory itemCategory) {
        Optional<ItemCategory> itemCategory1=itemCategoryRepository.findById(itemCategory.getItemCategoryId());
        ItemCategoryDto itemCategoryDto = new ItemCategoryDto();
        if(itemCategory1.isPresent()){
            ItemCategory itemCategory2=itemCategory1.get();
            itemCategory2.setItemTagName(itemCategory.getItemTagName());
            itemCategoryRepository.save(itemCategory2);
            itemCategoryDto.setItemCategory(itemCategory2);
            itemCategoryDto.setStatus("itemCategory Successfully updated");
        }else{
            itemCategoryDto.setItemCategory(itemCategory);
            itemCategoryDto.setStatus("itemCategory already exits ");
        }

        return itemCategoryDto;
    }

    public ItemCategoryDto removeItemCategory(Integer adminId, Integer itemCategoryId) {
        // verify admin Id
        Optional<ItemCategory> itemCategory=itemCategoryRepository.findById(itemCategoryId);
        ItemCategoryDto itemCategoryDto=new ItemCategoryDto();
        if(itemCategory.isPresent()){
            itemCategoryRepository.deleteById(itemCategoryId);
            itemCategoryDto.setStatus("Successfully deleted");
        }else{
            itemCategoryDto.setStatus("itemCategory does not exist");
        }
        return itemCategoryDto;
    }

    public List<Item> getItemsByItemCategory(Integer itemCategoryId) {
        Optional<ItemCategory> itemCategory=itemCategoryRepository.findById(itemCategoryId);
        if(itemCategory.isPresent()){
            return itemServices.getItemByItemCategory(itemCategoryId);
        }
        return new ArrayList<>();
    }

    public ItemCategory getItemCategory(Integer adminId, Integer itemCategoryId) {
        return itemCategoryRepository.findById(itemCategoryId).get();
    }

    public List<ItemCategory> getAllCategory() {
        return itemCategoryRepository.findAll();
    }
}
