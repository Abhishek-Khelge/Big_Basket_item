package com.item.services;

import com.item.dto.CategoryDto;
import com.item.entity.Category;
import com.item.entity.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {

    public CategoryDto addCategory(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategory(category);
        categoryDto.setStatus("Category successfully added.");

        return categoryDto;
    }

    public String updateCategory(Category category) {
        return "";
    }

    public String removeCategory(Integer categoryId) {
        return "";
    }

    public List<Category> getAllCategory() {
        return null;
    }

    public List<Item> getItemsByCategory(Integer categoryId) {
        return new ArrayList<>();
    }

    public Category getCategory(Integer adminId, Integer categoryId) {
        return null;
    }
}
