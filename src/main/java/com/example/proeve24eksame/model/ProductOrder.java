package com.example.proeve24eksame.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ProductOrder {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    @Column(name = "productorderid")
    private int productOrderId;
    private int quantity;

   @ManyToOne
   @JoinColumn(name = "delivery", referencedColumnName = "deliveryid")
   private Delivery delivery;

   @ManyToOne
   @JoinColumn(name = "product", referencedColumnName = "productid")
    private Product product;
}
