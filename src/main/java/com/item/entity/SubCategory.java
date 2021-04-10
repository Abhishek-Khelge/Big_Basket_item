package com.item.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.engine.profile.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "category","itemCategoryList","itemList"})
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subCatId;/**Primary key*/
    private String subCatName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category; /** Many to one relationship*/

    @OneToMany(mappedBy = "subCategory",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Item> itemList = new ArrayList<>();


    @OneToMany(mappedBy = "subCategory",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemCategory> itemCategoryList = new ArrayList<>();

    public Integer getCategoryId(){
        return this.category.getCategoryId();
    }


}
