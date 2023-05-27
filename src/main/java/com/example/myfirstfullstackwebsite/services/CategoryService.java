package com.example.myfirstfullstackwebsite.services;

import com.example.myfirstfullstackwebsite.dtos.CategoryDTO;
import com.example.myfirstfullstackwebsite.mappers.CategoryMapper;
import com.example.myfirstfullstackwebsite.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllChildCategories() {
        return categoryRepository
                .getChildCategories()
                .stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}
