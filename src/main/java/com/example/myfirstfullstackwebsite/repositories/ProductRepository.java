package com.example.myfirstfullstackwebsite.repositories;

import com.example.myfirstfullstackwebsite.dtos.ProductDTO;
import com.example.myfirstfullstackwebsite.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


//    @Query(name = "select * from Product ob where ob.category.id =: id")
//    List<ProductDTO> getAllProductsByCategoryId(@Param("id") Long categoryId);

    @Query(value = "select new com.example.myfirstfullstackwebsite.dtos.ProductDTO(ob.name, ob.price) from Product ob where ob.category.name = :category")
    List<ProductDTO> getProductsByCategory(@Param("category") String category);

}
