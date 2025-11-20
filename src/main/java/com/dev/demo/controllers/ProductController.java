package com.dev.demo.controllers;

import com.dev.demo.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String getAllProducts( ) {
        return null;
    }
    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id) {
        return "These are all products: "+id;
    }
    @DeleteMapping("/{id}")
    public void deleteProductById() {

    }

    @PostMapping()
    public void createProduct() {

    }
    @PutMapping("/{id}")
    public void updateProductById() {

    }
}
