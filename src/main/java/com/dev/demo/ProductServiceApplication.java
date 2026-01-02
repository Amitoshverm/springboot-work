package com.dev.demo;

import com.dev.demo.models.Category;
import com.dev.demo.models.Product;
import com.dev.demo.repository.CategoryRepository;
import com.dev.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	public ProductServiceApplication(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category category = new Category();
		category.setName("smartphones");

		Category category1 = categoryRepository.save(category);

		Product product = new Product();
		product.setTitle("iphone 19");
		product.setDescription("new iphone 19 with advanced features");
		product.setPrice(100000.00);
		product.setCategory(category1);

		productRepository.save(product);
	}
}
