package com.example.myfirstfullstackwebsite.repositories;

import com.example.myfirstfullstackwebsite.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> getProductsByCategoryId(@Param("category_id") Long category, Pageable pageable);
    Page<Product> findAllByOrderByIdAsc(Pageable pageable);

}
