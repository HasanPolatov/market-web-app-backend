package com.example.myfirstfullstackwebsite.repositories;

import com.example.myfirstfullstackwebsite.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
