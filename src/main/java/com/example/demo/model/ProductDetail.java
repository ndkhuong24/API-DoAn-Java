package com.example.demo.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productdetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @Column(name = "status")
    private Integer status;
}
