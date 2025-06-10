package com.example.E_commerce.Product.Catalog;

import com.example.E_commerce.Product.Catalog.model.Product;
import com.example.E_commerce.Product.Catalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECommerceProductCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceProductCatalogApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product("iPhone 15", "Latest Apple phone", 999.99, "Electronics", 10));
			productRepository.save(new Product("Samsung TV", "4K Smart LED TV", 499.99, "Electronics", 5));
			productRepository.save(new Product("Nike Shoes", "Running shoes for men", 79.99, "Footwear", 20));
			productRepository.save(new Product("Office Chair", "Ergonomic office chair", 129.99, "Furniture", 7));
			productRepository.save(new Product("Dell XPS", "High-performance laptop", 1199.99, "Computers", 4));
		};
	}
}
