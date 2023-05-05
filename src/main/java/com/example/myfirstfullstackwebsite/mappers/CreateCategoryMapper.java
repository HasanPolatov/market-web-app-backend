package com.example.myfirstfullstackwebsite.mappers;

import com.example.myfirstfullstackwebsite.dtos.CreateCategoryDTO;
import com.example.myfirstfullstackwebsite.entities.Category;

public class CreateCategoryMapper {

    public static CreateCategoryDTO toDTO(Category entity) {
        return CreateCategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .parentId(entity.getCategory() != null ? entity.getCategory().getId() : null)
                .build();
    }

    public static Category toEntity(CreateCategoryDTO dto) {
        return new Category()
                .id(dto.getId())
                .name(dto.getName())
                .category(dto.getParentId() != null ? new Category().id(dto.getParentId()) : null);
    }
}
