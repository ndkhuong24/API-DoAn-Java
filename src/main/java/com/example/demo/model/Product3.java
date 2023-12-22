package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product3 {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "status")
    private Integer status;

    @Column(name="brand")
    private String brand;

    @Column(name="category")
    private String category;

    @Column(name = "style")
    private String style;

    @Column(name="minPrice")
    private Integer minPrice;

    @Column(name = "maxPrice")
    private Integer maxPrice;
}
