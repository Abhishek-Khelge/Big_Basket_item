package com.item.controller;

import com.item.entity.Category;
import com.item.entity.Item;
import com.item.entity.SubCategory;
import com.item.services.SubCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubCategoryController {

    @Autowired
    SubCategoryServices subCategoryServices;

    @PostMapping("/subcategory/{adminId}")
    public String addSubCategory(@PathVariable("adminId") Integer adminId,
                                 @RequestBody SubCategory subCategory){
        return subCategoryServices.addSubCategory(adminId,subCategory);
    }

    //update sub-category
    @PutMapping("/subcategory/{adminId}/")
    public String updateSubCategory(@PathVariable("adminId") Integer adminId,
                             @RequestBody SubCategory subCategory){
        return subCategoryServices.updateSubCategory(adminId,subCategory);
    }

    // delete a sub-category
    @DeleteMapping("/subcategory/{adminId}/{subCategoryId}")
    public String removeSubCategory(@PathVariable("adminId") Integer adminId,
                                    @PathVariable("subCategoryId") Integer subCategoryId) {
        return subCategoryServices.removeSubCategory(adminId,subCategoryId);
    }

    //get all items by sub-category
    @GetMapping("/subcategory/{subCategory}")
    public List<Item> getItemsBySubCategory(@PathVariable("subCategory") Integer subCategory ){
        return subCategoryServices.getItemsBySubCategory(subCategory);
    }



}
