package com.example.myfirstfullstackwebsite.services;

import com.example.myfirstfullstackwebsite.dtos.CategoryDTO;
import com.example.myfirstfullstackwebsite.dtos.ProductDTO;
import com.example.myfirstfullstackwebsite.mappers.CategoryMapper;
import com.example.myfirstfullstackwebsite.mappers.ProductMapper;
import com.example.myfirstfullstackwebsite.repositories.CategoryRepository;
import com.example.myfirstfullstackwebsite.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductDTO getProductById(Long id) {
        return productRepository
                .findById(id)
                .map(ProductMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<ProductDTO> getAllProductsByCategoryId(Long categoryId, Model model) {

        if(categoryId != null) {
            model.addAttribute("selectedCategory", categoryRepository.findById(categoryId));
            return productRepository.getAllProductsByCategoryId(categoryId);
        } else {
            return productRepository
                    .findAll()
                    .stream()
                    .map(ProductMapper::toDTO)
                    .collect(Collectors.toList());
        }

    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        return ProductMapper.toDTO(productRepository
                .save(ProductMapper.toEntity(productDTO)));
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        return ProductMapper.toDTO(productRepository
                .save(ProductMapper.toEntity(productDTO)));
    }

    public boolean deleteProduct(Long id) {
        productRepository.deleteById(id);
        return true;
    }

}
