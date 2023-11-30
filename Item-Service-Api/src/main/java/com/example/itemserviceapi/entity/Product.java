package com.example.itemserviceapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * Coded By: Era Boy
 * Version: v0.1.0
 **/

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    private Long code;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "unitPrice", nullable = false)
    private double unitPrice;
    @Column(name = "qtyOnHand", nullable = false)
    private int qtyOnHand;
}
