package com.example.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductWithCategoryDTO {

    private int id;
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private boolean onSale;
    private String model;
    private String title;
    private String brand;
    private CategoryDTO categoryDTO;

}
