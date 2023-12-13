package com.example.proeve24eksame.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "productid")
    private int productId;
    private String name;
    private float price;
    private int weight;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<ProductOrder> productOrders = new HashSet<>();

}
