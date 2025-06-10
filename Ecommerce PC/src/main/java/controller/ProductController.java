package com.example.E_commerce.Product.Catalog.controller;

import com.example.E_commerce.Product.Catalog.model.Product;
import com.example.E_commerce.Product.Catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(service.save(product));
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setProductId(id);
        return ResponseEntity.ok(service.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Product> searchByName(@RequestParam String name) {
        return service.searchByName(name);
    }

    @GetMapping("/filter/category")
    public List<Product> filterByCategory(@RequestParam String category) {
        return service.filterByCategory(category);
    }

    @GetMapping("/filter/price")
    public List<Product> filterByPrice(@RequestParam double min, @RequestParam double max) {
        return service.filterByPriceRange(min, max);
    }
}

