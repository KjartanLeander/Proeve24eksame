package com.example.proeve24eksame.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Van {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vanid")
    private int vanId;
    private String brand;
    private String model;
    private int capacity;
}
