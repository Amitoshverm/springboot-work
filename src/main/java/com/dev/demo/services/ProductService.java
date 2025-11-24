package com.dev.demo.services;

import com.dev.demo.dtos.GenericProductDto;
import com.dev.demo.exceptions.NotFoundException;
import com.dev.demo.models.Product;

import java.util.*;

public interface ProductService {
    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto productDto);

    GenericProductDto deleteProductById(Long id);

    List<GenericProductDto> getAllProducts();

    GenericProductDto updateProductById(Long id, GenericProductDto productDto);
}
