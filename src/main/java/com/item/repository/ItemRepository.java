package com.item.repository;

import com.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  List<Student> findByStudentName(String name);
 *     List<Student> deleteStudentByStudentName(String name);
 *
 *     @Query(value = "select * from Student", nativeQuery = true)
 *     List<Student> findAllStudents();
 *
 *     @Query(value = "select * from Student where name=:name", nativeQuery = true)
 *     List<Student> findAllStudents(String name);

 *     @Modifying
 *     @Query(value = "insert into Student (id,name) VALUES (?1, ?2)", nativeQuery = true)
 *     @Transactional
 *     void addStudents(@Param("id") Long id, @Param("name") String name);
 *
 */
    @Repository
    public interface ItemRepository extends JpaRepository<Item,Integer> {

//    @Query(value = "select * from Student where name=:name", nativeQuery = true)


    @Query(value = "select * from Item where item_Category_Id=:itemCategoryId",nativeQuery = true)
    List<Item> getItemsByItemCategoryId(Integer itemCategoryId);

    @Query(value=" select * from Item where sub_Category_Id=:subCategoryId ", nativeQuery = true)
    List<Item> getItemsBySubCategoryId(Integer subCategoryId);

    @Query(value=" select * from Item where category_Id=:categoryId", nativeQuery = true)
    List<Item> getItemsByCategoryId(Integer categoryId);

}
