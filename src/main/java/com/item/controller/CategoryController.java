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
     * Description :
     *
     * @param adminId this i
     * @param category what is this
     * @return what is returning
     */
    @PostMapping("/category/{adminId}")
    public CategoryDto addCategory(@PathVariable("adminId") Integer adminId, @RequestBody Category category){
        return categoryServices.addCategory(category);
    }

    /**
     *
     * @param adminId
     * @param category
     * @return
     */
    @PutMapping("/category/{adminId}")
    public String updateCategory(@PathVariable("adminId") Integer adminId,@RequestBody Category category){
        return categoryServices.updateCategory(category);
    }

    // delete a particular category
    @DeleteMapping("/category/{adminId}/{categoryId}")
    public String removeCategory(@PathVariable("adminId") Integer adminId,
                            @PathVariable("categoryId") Integer categoryId){
        return categoryServices.removeCategory(categoryId);
    }

    // get All category
    @GetMapping("/category")
    public List<Category> getAllCategory(){
        return categoryServices.getAllCategory();
    }

    // get All Items By category
    @GetMapping("/category/items/{categoryId}")
    public List<Item> getItemsByCategory(@PathVariable("categoryId") Integer categoryId){
        return categoryServices.getItemsByCategory(categoryId);
    }

    // get a particular category information for admin
    @GetMapping("/category/{adminId}/{categoryId}")
    public Category getCategory(@PathVariable("adminId") Integer adminId,
                                          @PathVariable("categoryId") Integer categoryId){
        return categoryServices.getCategory(adminId,categoryId);
    }


}
