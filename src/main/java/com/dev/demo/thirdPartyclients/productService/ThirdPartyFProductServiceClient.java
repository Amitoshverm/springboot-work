package com.dev.demo.thirdPartyclients.productService;

import com.dev.demo.dtos.GenericProductDto;
import com.dev.demo.exceptions.NotFoundException;

import java.util.List;

public interface ThirdPartyFProductServiceClient {
    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto productDto);

    GenericProductDto deleteProductById(Long id);

    List<GenericProductDto> getAllProducts();

    GenericProductDto updateProductById(Long id, GenericProductDto productDto) throws NotFoundException;
}
