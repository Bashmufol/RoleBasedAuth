package com.bash.rolebasedpractice.controller;

import com.bash.rolebasedpractice.model.Products;
import com.bash.rolebasedpractice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN_CREATE')")
    public Products addProduct(Products product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable Long id, @RequestBody Products product) {
        return productService.updateProduct(id, product);
    }

    @GetMapping("/{id}")
    public Optional<Products> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN_DELETE')")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }




}
