package com.example.myfirstfullstackwebsite.mappers;

import com.example.myfirstfullstackwebsite.dtos.CategoryDTO;
import com.example.myfirstfullstackwebsite.entities.Category;

public class CategoryMapper {

    public static CategoryDTO toDTO(Category entity) {
        return CategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO dto) {
        return new Category()
                .id(dto.getId())
                .name(dto.getName());
    }

}
