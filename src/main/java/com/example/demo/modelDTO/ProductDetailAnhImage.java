package com.example.demo.modelDTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class ProductDetailAnhImage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_id")
    private Integer category_id;

    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "size_id")
    private Integer size_id;

    @Column(name = "color_id")
    private Integer color_id;

    @Column(name = "sole_id")
    private Integer sole_id;

    @Column(name = "material_id")
    private Integer material_id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Integer price;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "product_detail_id")
    private Integer product_detail_id;
}
