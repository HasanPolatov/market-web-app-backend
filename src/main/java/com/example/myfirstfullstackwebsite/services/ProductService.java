package com.example.myfirstfullstackwebsite.services;

import com.example.myfirstfullstackwebsite.dtos.ProductDTO;
import com.example.myfirstfullstackwebsite.mappers.ProductMapper;
import com.example.myfirstfullstackwebsite.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public ProductDTO getProductById(Long id) {
        return productRepository
                .findById(id)
                .map(ProductMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Page<ProductDTO> getProducts(Long categoryId, Pageable pageable) {
        if (categoryId != null) {
            return productRepository
                    .getProductsByCategoryId(categoryId, pageable)
                    .map(ProductMapper::toDTO);
        } else {
            return productRepository
                    .findAllByOrderByIdAsc(pageable)
                    .map(ProductMapper::toDTO);
        }
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

}
