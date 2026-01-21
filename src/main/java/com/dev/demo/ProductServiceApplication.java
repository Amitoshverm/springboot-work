package com.dev.demo;

import com.dev.demo.models.Address;
import com.dev.demo.models.Category;
import com.dev.demo.models.Person;
import com.dev.demo.models.Product;
import com.dev.demo.repository.AddressRepository;
import com.dev.demo.repository.CategoryRepository;
import com.dev.demo.repository.PersonRepository;
import com.dev.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

//	private ProductRepository productRepository;
//	private CategoryRepository categoryRepository;
//	private PersonRepository personRepository;
//	private AddressRepository addressRepository;
//
//	public ProductServiceApplication(ProductRepository productRepository, CategoryRepository categoryRepository,
//									 PersonRepository personRepository, AddressRepository addressRepository) {
//		this.productRepository = productRepository;
//		this.categoryRepository = categoryRepository;
//		this.personRepository = personRepository;
//		this.addressRepository = addressRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
//
//	@Override
//	public void run(String... args) throws Exception {
////		Category category = new Category();
////		category.setName("smartphones");
////
////		Category category1 = categoryRepository.save(category);
////
////		Product product = new Product();
////		product.setTitle("iphone 19");
////		product.setDescription("new iphone 19 with advanced features");
////		product.setPrice(100000.00);
////		product.setCategory(category1);
////
////		productRepository.save(product);
//
//		Person person = new Person();
//		Address address = new Address();
////
////		address.setAddressLine("Gaur homes ghaziabad");
////
////		person.setName("John Doe");
////		person.setAddress(address);
////		personRepository.save(person);
//		personRepository.deleteById(2L);
//	}
}
