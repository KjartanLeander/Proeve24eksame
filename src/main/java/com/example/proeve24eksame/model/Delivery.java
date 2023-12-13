package com.example.proeve24eksame.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Delivery {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "deliveryid")
    private int deliveryId;

    private LocalDate deliveryDate;
    private String fromWarehouse;
    private String destination;

    @OneToMany(mappedBy = "delivery")
    @JsonBackReference
    private Set<ProductOrder> productOrders = new HashSet<>();
}
