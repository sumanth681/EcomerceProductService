package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category extends  BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category" , fetch =  FetchType.EAGER)
    private List<Product> productEntities;
}
