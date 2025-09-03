package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Category extends  BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category" , fetch =  FetchType.EAGER)
    private List<Product> productEntities;
}
