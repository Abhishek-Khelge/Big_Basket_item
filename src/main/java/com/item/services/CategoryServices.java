package com.item.services;

import com.item.dto.CategoryDto;
import com.item.entity.Category;
import com.item.entity.Item;
import com.item.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {
     @Autowired
     CategoryRepository categoryRepository;

     @Autowired
     ItemServices itemServices;

    public CategoryDto addCategory(Integer adminId,Category category) {
        //verify admin
        Category category1 = categoryRepository.save(category);
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategory(category1);
        categoryDto.setStatus("Category successfully added.");
        return categoryDto;
    }

    public CategoryDto updateCategory(Integer adminId,Category category) {
        //verify admin
        Optional<Category> category1=categoryRepository.findById(category.getCategoryId());
        CategoryDto categoryDto = new CategoryDto();
        if(category1.isPresent()) {
            Category category2 = category1.get();
            category2.setCategoryName(category.getCategoryName());
            categoryRepository.save(category2);
            categoryDto.setCategory((Category) category2);
            categoryDto.setStatus("Category successfully updated.");
        }else{
            categoryDto.setCategory(category);
            categoryDto.setStatus("Category does not exist.");
        }
        return categoryDto;
    }

    public CategoryDto removeCategory(Integer adminId,Integer categoryId) {
        //verify admin
        Optional<Category> category = categoryRepository.findById(categoryId);
        CategoryDto  categoryDto = new CategoryDto();
        if(category.isPresent()){
            categoryRepository.deleteById(categoryId);
            categoryDto.setStatus("Category successfully removed.");
        }else{
            categoryDto.setStatus("Category does not exist.");
        }
        return categoryDto;
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public List<Item> getItemsByCategory(Integer categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()){
            return itemServices.getItemsByCategory(categoryId);
        }
        return new ArrayList<>();
    }

    public CategoryDto getCategory(Integer adminId, Integer categoryId) {
        //verify admin
        Optional<Category> category =categoryRepository.findById(categoryId);
        CategoryDto categoryDto = new CategoryDto();
        if(category.isPresent())
        {
            categoryDto.setCategory(category.get());
            categoryDto.setStatus("admin exist and verified");
            return categoryDto;
        }
        categoryDto.setStatus("user does not exist");
        return categoryDto;
    }
}
