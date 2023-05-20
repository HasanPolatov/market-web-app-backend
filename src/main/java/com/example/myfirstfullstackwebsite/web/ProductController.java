package com.example.myfirstfullstackwebsite.web;

import com.example.myfirstfullstackwebsite.dtos.ProductDTO;
import com.example.myfirstfullstackwebsite.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("product")
    public ProductDTO createProduct(@RequestBody() ProductDTO product) {
        return productService.createProduct(product);
    }

    @GetMapping("products")
    public List<ProductDTO> listProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("product-by-category")
    public List<ProductDTO> getProductsByCategory(@RequestParam String category) {
        if (Objects.equals(category, "all")) {
            return listProducts();
        } else {
            return productService.getProductsByCategory(category);
        }
    }

    @DeleteMapping("product")
    public boolean deleteProduct(@RequestParam Long id) {
        return productService.deleteProduct(id);
    }

}
