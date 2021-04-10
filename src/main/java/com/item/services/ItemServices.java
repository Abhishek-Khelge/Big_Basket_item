package com.item.services;

import com.item.dto.CategoryDto;
import com.item.dto.ItemDto;
import com.item.entity.Category;
import com.item.entity.Item;
import com.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServices {


    @Autowired
    ItemRepository itemRepository;

    public ItemDto addItem(Integer adminId, Item item) {
       Item item1=itemRepository.save(item);
       ItemDto itemDto=new ItemDto();
       itemDto.setItem(item1);
       itemDto.setStatus("item Successfull added");
       return itemDto;
    }

    public ItemDto updateItem(Integer adminId, Item item) {
       Optional<Item> item1=itemRepository.findById(item.getItemId());
       ItemDto itemDto=new ItemDto();
       if(item1.isPresent()){
           Item item2= item1.get();
           item2.setItemDesc(item.getItemDesc());
           item2.setCategory(item.getCategory());
           item2.setItemName(item.getItemName());
           item2.setItemCategory(item.getItemCategory());
           item2.setItemType(item.getItemType());
           itemRepository.save(item2);
           itemDto.setItem(item2);
           itemDto.setStatus(" item updated successfully");
       }else{
        //   itemDto.getItem(item);
           itemDto.setStatus("item does not exits");
       }
       return itemDto;
    }

    public ItemDto removeItem(Integer adminId, Integer itemId) {
        Optional<Item> item=itemRepository.findById(itemId);
        ItemDto itemDto=new ItemDto();
        if(item.isPresent()){
            itemRepository.deleteById(itemId);
            itemDto.setStatus("item successfully removed.");
        }else{
            itemDto.setStatus("item does not exist.");
        }
        return itemDto;
    }

    public Item getItemById(Integer itemId) {
        Optional<Item> item = itemRepository.findById(itemId);
        if(item.isPresent())
            return item.get();
        return null;
    }
//
//    public List<Item> getItemsByCategory(Integer categoryId){
//        List<Item> itemList = itemRepository.getItemsByCategoryId(categoryId);
//        return itemList;
//    }
//
//    public List<Item> getItemByItemCategory(Integer itemCategoryId ){
//        List<Item> itemList = itemRepository.getItemsByItemCategoryId(itemCategoryId);
//        return itemList;
//    }
//    public List<Item> getItemBySubCategory(Integer subCategoryId ){
//        List<Item> itemList = itemRepository.getItemsBySubCategoryId(subCategoryId);
//        return itemList;
//    }

}
