package com.example.demo.DTO;

import lombok.*;

import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategoriesResponseDTO {
	private String message;
	private String status;
	private List<ProductsItem> products;

}