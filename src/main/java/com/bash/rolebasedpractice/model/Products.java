package com.bash.rolebasedpractice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_table")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;
    private String productDescription;
    private String productPrice;
    private String productCategory;
}
