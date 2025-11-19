package com.dev.demo.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

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
