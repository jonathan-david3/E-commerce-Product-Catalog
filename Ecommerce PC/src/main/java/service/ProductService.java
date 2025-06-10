package com.example.E_commerce.Product.Catalog.service;


import com.example.E_commerce.Product.Catalog.model.Product;
import com.example.E_commerce.Product.Catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product save(Product product) {
        return repo.save(product);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Optional<Product> getById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Product> filterByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Product> filterByPriceRange(double min, double max) {
        return repo.findByPriceBetween(min, max);
    }

    public List<Product> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }
}

