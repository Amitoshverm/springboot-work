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
    public ResponseEntity<List<GenericProductDto>> getAllProducts( ) {
        List<GenericProductDto> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(products,HttpStatus.NOT_FOUND);
        }
        return new  ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        GenericProductDto genericProductDto =  this.productService.getProductById(id);
        if  (genericProductDto == null) {
            throw new NotFoundException("Product not found");
        }
//        GenericProductDto productDto = new GenericProductDto();
//        productDto.setTitle("something");
        return genericProductDto;
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
