package com.dev.demo.services;

import com.dev.demo.dtos.GenericProductDto;
import com.dev.demo.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("selfProductService")
public class SelfProductService implements ProductService{
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto productDto) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto productDto) {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }
}
