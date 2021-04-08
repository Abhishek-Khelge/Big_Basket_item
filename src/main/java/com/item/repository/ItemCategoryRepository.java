package com.item.repository;

import com.item.entity.Item;
import com.item.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Integer> {
}
