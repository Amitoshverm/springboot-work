package com.dev.demo.controllers;

import com.dev.demo.dtos.GenericProductDto;
import com.dev.demo.exceptions.NotFoundException;
import com.dev.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public GenericProductDto createProduct(@RequestBody GenericProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping()
    public List<GenericProductDto> getAllProducts( ) {
        return this.productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return this.productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id) {
        return this.productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericProductDto>
    updateProductById(@PathVariable("id") Long id,
                      @RequestBody GenericProductDto productDto) throws NotFoundException{
        return new ResponseEntity<>(this.productService.updateProductById(id, productDto), HttpStatus.OK);
    }
}
