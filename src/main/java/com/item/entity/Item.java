package com.item.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "itemCategory"})
public class Item {

    @Id
    private Integer itemId;/**primary key*/
    private String itemDesc;/**Description of Item*/
    private String itemName;
    private Integer brandId;
    private String itemPicName;
    private String itemType;
    private Integer itemExpiryDate;
    private Integer itemBoughtDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private ItemCategory itemCategory;


}
