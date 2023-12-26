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
public class ProductDetailCart {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @Column(name = "material")
    private String material;

    @Column(name = "sole")
    private String sole;

    @Column(name = "price")
    private String price;

    @Column(name = "quantity")
    private String quantity;
}
