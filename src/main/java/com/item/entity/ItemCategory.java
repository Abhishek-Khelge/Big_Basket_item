package com.item.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "itemList","subCategory"})
public class ItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemCategoryId;
    private String itemTagName;

    @OneToMany(mappedBy = "itemCategory",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Item> itemList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private SubCategory subCategory;



}
