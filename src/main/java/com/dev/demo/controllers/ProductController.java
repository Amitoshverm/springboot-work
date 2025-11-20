package com.dev.demo.controllers;

import com.dev.demo.dtos.GenericProductDto;
import com.dev.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String getAllProducts( ) {
        return null;
    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return this.productService.getProductById(id);
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
