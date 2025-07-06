package com.example.demo.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO{
	private String image;
	private String color;
	private int price;
	private String description;
	private int discount;
	private boolean onSale;
	private String model;
	private int id;
	private String title;
	private String category;
	private String brand;
}