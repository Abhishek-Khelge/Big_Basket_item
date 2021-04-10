package com.item.dto;

import com.item.entity.Category;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class CategoryDto {

    Category category;
    String status;

}
