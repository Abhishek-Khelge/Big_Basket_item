package com.item.controller;
import com.item.dto.CategoryDto;
import com.item.entity.Category;
import com.item.entity.Item;
import com.item.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryServices categoryServices;

    /**
     * Description :  add category to DB
     * @param adminId this is for checking authorization
     * @param category input category
     * @return status
     */
    @PostMapping("/category/{adminId}")
    public CategoryDto addCategory(@PathVariable("adminId") Integer adminId, @RequestBody Category category){
        return categoryServices.addCategory(adminId,category);
    }

    /**
     * Description : update the category
     * @param adminId this is for checking authorization
     * @param category update category body
     * @return status
     */
    @PutMapping("/category/{adminId}")
    public CategoryDto updateCategory(@PathVariable("adminId") Integer adminId,@RequestBody Category category){
        return categoryServices.updateCategory(adminId,category);
    }

    /**
     * Description : to delete the category
     * @param adminId this is for checking authorization
     * @param categoryId to point which category to delete
     * @return status
     */
    @DeleteMapping("/category/{adminId}/{categoryId}")
    public CategoryDto removeCategory(@PathVariable("adminId") Integer adminId,
                                      @PathVariable("categoryId") Integer categoryId){
        return categoryServices.removeCategory(adminId,categoryId);
    }

    /**
     * Description : return all the  category
     * @return returning list of all the category information
     */
    @GetMapping("/category")
    public List<Category> getAllCategory(){
        return categoryServices.getAllCategory();
    }

    /**
     * Description : To fetch all the items which belong to same category
     * @param categoryId : to get all Items of same category using categoryId.
     * @return returning the list of items.
     */
    @GetMapping("/category/items/{categoryId}")
    public List<Item> getItemsByCategory(@PathVariable("categoryId") Integer categoryId){
        return categoryServices.getItemsByCategory(categoryId);
    }

    /**
     * Description : to get Information one category by using CategoryId
     * @param adminId this is for checking authorization
     * @param categoryId this is for getting Information of category by using categoryId
     * @return returning the information of one category
     */
    @GetMapping("/category/{adminId}/{categoryId}")
    public CategoryDto getCategory(@PathVariable("adminId") Integer adminId,
                                   @PathVariable("categoryId") Integer categoryId){
        return categoryServices.getCategory(adminId,categoryId);
    }


}
