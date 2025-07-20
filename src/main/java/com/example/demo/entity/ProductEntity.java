package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity extends BaseEntity {
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private int id;
    private boolean onSale;
    private String model;
    private String title;
    private String brand;


    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name ="category_id" , nullable = false)
    private CategoryEntity category;

}
