package com.bash.rolebasedpractice.repository;

import com.bash.rolebasedpractice.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
