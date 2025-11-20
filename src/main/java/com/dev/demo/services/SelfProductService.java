package com.dev.demo.services;

import com.dev.demo.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("selfProductService")
public class SelfProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
