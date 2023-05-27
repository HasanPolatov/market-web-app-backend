package com.example.myfirstfullstackwebsite.web;

import com.example.myfirstfullstackwebsite.dtos.ProductDTO;
import com.example.myfirstfullstackwebsite.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping("product")
    public ProductDTO createProduct(@RequestBody ProductDTO product) {
        logger.info("Creating product: {}", product.toString());
        product.setCategoryId(1L);
        return productService.createProduct(product);
    }

    @PutMapping("product")
    public ProductDTO updateProduct(@RequestBody ProductDTO product) {
        logger.info("Updating product: {}", product.toString());
        return productService.updateProduct(product);
    }

    @GetMapping("products")
    public List<ProductDTO> listProducts() {
        logger.info("Listing all products");
        return productService.getAllProducts();
    }

    @GetMapping("product-by-category")
    public List<ProductDTO> getProductsByCategory(@RequestParam Long categoryId) {
        logger.info("Getting products by category: {}", categoryId);
        return productService.getProductsByCategory(categoryId);
    }

    @DeleteMapping("product/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        logger.info("Deleting product with ID: {}", id);
        return productService.deleteProduct(id);
    }
}
