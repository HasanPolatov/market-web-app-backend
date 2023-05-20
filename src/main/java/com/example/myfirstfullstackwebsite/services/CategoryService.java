package com.example.myfirstfullstackwebsite.services;

import com.example.myfirstfullstackwebsite.dtos.CategoryDTO;
import com.example.myfirstfullstackwebsite.mappers.CategoryMapper;
import com.example.myfirstfullstackwebsite.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<CategoryDTO> getAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getAllCategoriesForSelect() {
        return categoryRepository
                .findAll()
                .stream()
                .filter(category -> category.getCategory() != null)
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}
