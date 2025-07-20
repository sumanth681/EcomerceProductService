package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categoryList")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryEntity extends  BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category" , fetch =  FetchType.EAGER)
    private List<ProductEntity> productEntities;
}
