package com.item.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "itemCategory","subCategory","category"})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;/**primary key*/
    private String itemDesc;/**Description of Item*/
    private String itemName;
    private Integer brandId;
    private String itemPicName;
    private String itemType;
    private String itemExpiryDate;
    private String itemBoughtDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemCategoryId")
    private ItemCategory itemCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="subCategoryId")
    private SubCategory subCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CategoryId")
    private Category category;

    public Integer getCategoryId(){
        return this.category.getCategoryId();
    }

    public Integer getSubCategoryId(){
        return this.subCategory.getSubCatId();
    }
    public Integer getItemCategoryId(){
        return this.itemCategory.getItemCategoryId();
    }



}
