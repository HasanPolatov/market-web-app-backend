package com.example.myfirstfullstackwebsite.web;

import com.example.myfirstfullstackwebsite.dtos.ProductDTO;
import com.example.myfirstfullstackwebsite.services.CategoryService;
import com.example.myfirstfullstackwebsite.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

//    @GetMapping("product/{id}")
//    public ProductDTO getProductById(@PathVariable Long id) {
//        return productService.getProductById(id);
//    }
//
    @GetMapping("/home")
    public String createProductForm() {
        return "main";
    }

    @PostMapping("product")
    public String createProduct(@ModelAttribute("product") ProductDTO product) {
        productService.createProduct(product);
        return "redirect:/api/products";
    }

    @GetMapping("products")
    public String listProducts(@RequestParam(name = "category", required = false) Long categoryId, Model model) {
        List<ProductDTO> products = productService.getAllProductsByCategoryId(categoryId, model);
        model.addAttribute("products", products);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product";
    }

    @GetMapping("create-product")
    public String createProductForm(Model model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategoriesForSelect());
        model.addAttribute("showForm", true);

        return "product";
    }


    @PutMapping("product")
    public ProductDTO updateProduct(@RequestBody ProductDTO product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("product")
    public boolean deleteProduct(@RequestParam Long id) {
        return productService.deleteProduct(id);
    }

    @ModelAttribute("setHomeActive")
    public String setHomeActive() {
        return "home";
    }

    @ModelAttribute("setProductsActive")
    public String setProductsActive() {
        return "products";
    }

    @ModelAttribute("setCreateActive")
    public String setCreateActive() {
        return "create";
    }


}
