package com.item.services;

import com.item.dto.ItemCategoryDto;
import com.item.dto.SubCategoryDto;
import com.item.entity.Category;
import com.item.entity.Item;
import com.item.entity.ItemCategory;
import com.item.entity.SubCategory;
import com.item.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryServices {

    @Autowired
    SubCategoryRepository subCategoryRepo;

    @Autowired
    ItemServices itemServices;
    public SubCategoryDto addSubCategory(Integer adminId, SubCategory subCategory) {
        /**Verify admin*/
        SubCategory subCategory1 =  subCategoryRepo.save(subCategory);
        SubCategoryDto subCategoryDto = new SubCategoryDto();
        subCategoryDto.setSubCategory(subCategory1);
        subCategoryDto.setStatus("Sub-Category successfully added");
        return subCategoryDto;
    }


    public SubCategoryDto updateSubCategory(Integer adminId, SubCategory subCategory) {
        /**Verify admin*/
        Optional<SubCategory> subCategory1 = subCategoryRepo.findById(subCategory.getCategoryId());
        SubCategoryDto subCatDto = new SubCategoryDto();
        if(subCategory1.isPresent()){
            subCategory1.get().setSubCatName(subCategory.getSubCatName());
            subCategoryRepo.save(subCategory1.get());
            subCatDto.setSubCategory(subCategory);
            subCatDto.setStatus("Sub-Category successfully updated");
        }else{
            subCatDto.setSubCategory(subCategory);
            subCatDto.setStatus("Sub-Category is not updated due to some internal error");
        }
        return subCatDto;
    }

    public SubCategoryDto removeSubCategory(Integer adminId, Integer subCategoryId) {
        /**Verify admin*/
        Optional<SubCategory> subCategory = subCategoryRepo.findById(subCategoryId);
        SubCategoryDto subCategoryDto = new SubCategoryDto();
        if(subCategory.isPresent()){
            subCategoryRepo.deleteById(subCategoryId);
            subCategoryDto.setStatus("Successfully deleted");
        }else{
            subCategoryDto.setStatus("sub-category does not exist.");
        }
        return subCategoryDto;
    }

    public List<Item> getItemsBySubCategory(Integer subCategoryId) {
        Optional<SubCategory> subCategory = subCategoryRepo.findById(subCategoryId);
        if(subCategory.isPresent()){
            return itemServices.getItemBySubCategory(subCategoryId);
        }
        return new ArrayList<>();
    }


    public List<SubCategory> getAllCategory() {
        return subCategoryRepo.findAll();
    }

    public SubCategory getSubCategory(Integer adminId, Integer itemCategoryId) {
        return subCategoryRepo.findById(itemCategoryId).get();
    }
}
