package com.example.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCustom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer category_id;

    private Integer brand_id;

    private Integer product_id;

    private Integer size_id;

    private Integer color_id;

    private Integer sole_id;

    private Integer material_id;

    private Integer quantity;

    private Integer price;

    private String name;

    private String url;

    private Integer status;
}
