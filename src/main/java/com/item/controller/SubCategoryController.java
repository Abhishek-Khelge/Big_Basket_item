package com.item.controller;

import com.item.dto.SubCategoryDto;
import com.item.entity.Category;
import com.item.entity.Item;
import com.item.entity.ItemCategory;
import com.item.entity.SubCategory;
import com.item.services.SubCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubCategoryController {

    @Autowired
    SubCategoryServices subCategoryServices;

    /**
     * Description : add subCategory to data base
     * @param adminId : to verify admin using adminID
     * @param subCategory : Requesting Body of subCategory
     * @return : subCategory Dto
     */
    @PostMapping("/subcategory/{adminId}")
    public SubCategoryDto addSubCategory(@PathVariable("adminId") Integer adminId,
                                         @RequestBody SubCategory subCategory){
        return subCategoryServices.addSubCategory(adminId,subCategory);
    }

    //

    /**
     * Description : update sub-category
     * @param adminId :to verify admin using adminID
     * @param subCategory : Requesting Body of subCategory
     * @return :SubCategoryDto
     */
    @PutMapping("/subcategory/{adminId}/")
    public SubCategoryDto updateSubCategory(@PathVariable("adminId") Integer adminId,
                             @RequestBody SubCategory subCategory){
        return subCategoryServices.updateSubCategory(adminId,subCategory);
    }

    /**
     * Description : delete a sub-category
     * @param adminId :to verify admin using adminID
     * @param subCategoryId : Requesting Body of subCategory
     * @return : SubCategoryDto
     */
    @DeleteMapping("/subcategory/{adminId}/{subCategoryId}")
    public SubCategoryDto removeSubCategory(@PathVariable("adminId") Integer adminId,
                                    @PathVariable("subCategoryId") Integer subCategoryId) {
        return subCategoryServices.removeSubCategory(adminId,subCategoryId);
    }

    /**
     * Description : get all subCategory
     * @return list of subCategory
     */
    @GetMapping("/subcategory")
    public List<SubCategory> getAllSubCategory(){
        return subCategoryServices.getAllCategory();
    }

    /**
     * Description : get a Subcategory by subCategoryId
     * @param adminId :to verify admin using adminID
     * @param subCategoryId : sub category Id
     * @return : subcategory object
     */
    @GetMapping("/subcategory/{adminId}/{subCategoryId}")
    public SubCategory getSubCategory(@PathVariable("adminId") Integer adminId,
                                      @PathVariable("itemCategoryId") Integer subCategoryId){
        return subCategoryServices.getSubCategory(adminId,subCategoryId);
    }

    /**
     * Description : get all items by sub-category
     * @param subCategoryId : a particular sub-categoryId
     * @return : list of all items by subcategory
     */
    @GetMapping("/subcategory/items/{subCategoryId}")
    public List<Item> getItemsBySubCategory(@PathVariable("subCategoryId") Integer subCategoryId ){
        return subCategoryServices.getItemsBySubCategory(subCategoryId);
    }



}
