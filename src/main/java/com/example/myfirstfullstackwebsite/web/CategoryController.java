package com.example.myfirstfullstackwebsite.web;

import com.example.myfirstfullstackwebsite.dtos.CategoryDTO;
import com.example.myfirstfullstackwebsite.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping("categories")
    public List<CategoryDTO> getAllCategories() {
        logger.info("Listing categories");
        return categoryService.getAllChildCategories();
    }

}
