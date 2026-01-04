package com.dev.demo.services;

import com.dev.demo.dtos.GenericProductDto;
import com.dev.demo.models.Category;
import com.dev.demo.models.Product;
import com.dev.demo.repository.CategoryRepository;
import com.dev.demo.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return convertToGenericProductDto(product);

    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = this.productRepository.findAll();
        return products.stream().map(this::convertToGenericProductDto).toList();
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto productDto) {
       Product updatedProduct = this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
       updatedProduct.setTitle(productDto.getTitle());
       updatedProduct.setDescription(productDto.getDescription());
       updatedProduct.setPrice(productDto.getPrice());
       Category category = new Category();
       category.setName(productDto.getCategory());
       categoryRepository.save(category);
       updatedProduct.setCategory(category);
       this.productRepository.save(updatedProduct);

       return this.convertToGenericProductDto(updatedProduct);
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        categoryRepository.save(category);
        product.setCategory(category);
        Product savedProduct = this.productRepository.save(product);
        return this.convertToGenericProductDto(savedProduct);
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        this.productRepository.deleteById(id);
        return this.convertToGenericProductDto(product);
    }

    private GenericProductDto convertToGenericProductDto(Product product) {
        GenericProductDto productDto = new GenericProductDto();
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategory(product.getCategory().getName());
        return productDto;
    }
}
