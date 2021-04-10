package com.item.services;

import com.item.entity.Item;
import com.item.entity.ItemCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCategoryServices {
    public String addItemCategory(Integer adminId, ItemCategory itemCategory) {
        return "";
    }

    public String updateItemCategory(Integer adminId, ItemCategory itemCategory) {
        return "";
    }

    public String removeItemCategory(Integer adminId, Integer itemCategoryId) {
        return "";
    }

    public List<Item> getItemsByItemCategory(Integer itemCategoryId) {
        return new ArrayList<>();
    }

    public ItemCategory getItemCategory(Integer adminId, Integer itemCategoryId) {
        return null;
    }
}
