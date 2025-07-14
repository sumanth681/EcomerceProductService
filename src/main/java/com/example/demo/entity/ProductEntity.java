package com.example.demo.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductEntity extends BaseEntity {
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private boolean onSale;
    private String model;
    private String title;
    private String category;
    private String brand;
}
