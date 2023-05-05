package com.example.myfirstfullstackwebsite.mappers;

import com.example.myfirstfullstackwebsite.dtos.ProductDTO;
import com.example.myfirstfullstackwebsite.entities.Category;
import com.example.myfirstfullstackwebsite.entities.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product entity) {
        return ProductDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .categoryId(entity.getCategory() != null ? entity.getCategory().getId() : null)
                .build();
    }

    public static Product toEntity(ProductDTO dto) {
        return new Product()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .category(dto.getCategoryId() != null ? new Category().id(dto.getCategoryId()) : null);
    }

}
