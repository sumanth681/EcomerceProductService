package com.example.demo.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO{
	private int id;
	private String image;
	private String color;
	private int price;
	private String description;
	private int discount;
	private boolean onSale;
	private String model;
	private String title;
	private int  categoryId;
	private String brand;
}