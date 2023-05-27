package com.example.myfirstfullstackwebsite.repositories;

import com.example.myfirstfullstackwebsite.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c " +
            " WHERE NOT EXISTS " +
            "(SELECT 1 FROM Category c1 WHERE c1.category.id = c.id)")
    List<Category> getChildCategories();

}
