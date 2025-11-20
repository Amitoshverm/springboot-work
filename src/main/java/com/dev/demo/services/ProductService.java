package com.dev.demo.services;

import com.dev.demo.models.Product;

import java.util.*;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();

}
