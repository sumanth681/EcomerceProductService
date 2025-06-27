package com.example.demo.DTO;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreCategoryResponseDTO {
    String status;
    String message;
    List<String> categories;
}
