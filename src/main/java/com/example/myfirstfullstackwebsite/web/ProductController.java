package com.example.myfirstfullstackwebsite.web;

import com.example.myfirstfullstackwebsite.dtos.ProductDTO;
import com.example.myfirstfullstackwebsite.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);


    @GetMapping("product/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("products")
    public List<ProductDTO> getProducts(@RequestParam(required = false) Long categoryId, Pageable pageable) {
        return productService.getProducts(categoryId, pageable).getContent();
    }

    @PostMapping("product")
    public ProductDTO createProduct(@RequestBody ProductDTO product) {
        logger.info("Creating product: {}", product.toString());
        return productService.createProduct(product);
    }

    @PutMapping("product")
    public ProductDTO updateProduct(@RequestBody ProductDTO product) {
        logger.info("Updating product: {}", product.toString());
        return productService.updateProduct(product);
    }

    @DeleteMapping("product/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        logger.info("Deleting product with ID: {}", id);
        return productService.deleteProduct(id);
    }
}
