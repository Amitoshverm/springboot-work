package com.dev.demo.services;

import com.dev.demo.dtos.GenericProductDto;
import com.dev.demo.models.Product;

import java.util.*;

public interface ProductService {
    GenericProductDto getProductById(Long id);
    List<Product> getAllProducts();

}
