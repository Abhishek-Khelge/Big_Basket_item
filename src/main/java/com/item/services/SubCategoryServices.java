package com.item.services;

import com.item.entity.Item;
import com.item.entity.SubCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryServices {
    public String addSubCategory(Integer adminId, SubCategory subCategory) {
        return "";
    }

    public String updateSubCategory(Integer adminId, SubCategory subCategory) {
        return "";
    }

    public String removeSubCategory(Integer adminId, Integer subCategoryId) {
        return "";
    }

    public List<Item> getItemsBySubCategory(Integer subCategory) {
        return new ArrayList<>();
    }
}
