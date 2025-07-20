package com.example.demo.DTO;

import lombok.*;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CategoryWithProductsDTo {
    long category_id ;
    String name;
    //CategoryDTO category;
    List<ProductDTO> products;
}
