package com.bash.rolebasedpractice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_table")
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private String productCategory;
}
