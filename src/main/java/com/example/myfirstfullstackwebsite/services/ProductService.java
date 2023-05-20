package com.example.myfirstfullstackwebsite.services;

import com.example.myfirstfullstackwebsite.dtos.ProductDTO;
import com.example.myfirstfullstackwebsite.mappers.ProductMapper;
import com.example.myfirstfullstackwebsite.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductDTO getProductById(Long id) {
        return productRepository
                .findById(id)
                .map(ProductMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());

    }


    public ProductDTO createProduct(ProductDTO productDTO) {
        return ProductMapper.toDTO(productRepository
                .save(ProductMapper.toEntity(productDTO))
        );
    }


    public ProductDTO updateProduct(ProductDTO productDTO) {
        return ProductMapper.toDTO(productRepository
                .save(ProductMapper.toEntity(productDTO)));
    }

    public boolean deleteProduct(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    public List<ProductDTO> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }
}
