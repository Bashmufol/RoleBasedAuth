package com.bash.rolebasedpractice.service;

import com.bash.rolebasedpractice.exceptions.ResourceNotFoundException;
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
        Optional<Products> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product;
        } else {
            throw new ResourceNotFoundException("Cannot find product with the Id: " + id);
        }
    }

    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }

    public Optional<Products> updateProduct(Long id, Products product) {
        Optional<Products> existingProductOptional = productRepository.findById(id);
        if(existingProductOptional.isPresent()){
            Products existingProduct = existingProductOptional.get();
            existingProduct.setProductName(product.getProductName());
            existingProduct.setProductPrice(product.getProductPrice());
            existingProduct.setProductDescription(product.getProductDescription());
            existingProduct.setProductCategory(product.getProductCategory());
            productRepository.save(existingProduct);
            return Optional.of(existingProduct);
        } else {
            throw new ResourceNotFoundException("Product not found with ID: " + id);
        }
    }

    public void deleteProduct(Long id) {
        boolean exists = productRepository.existsById(id);
        if (exists) {
            productRepository.deleteById(id);
        } else{
            throw new ResourceNotFoundException("Product not found with ID: " + id);
        }
    }

}
