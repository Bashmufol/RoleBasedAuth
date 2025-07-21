package com.bash.rolebasedpractice.service;

import com.bash.rolebasedpractice.model.Products;
import com.bash.rolebasedpractice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Products> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }

    public Products updateProduct(Long id, Products product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
