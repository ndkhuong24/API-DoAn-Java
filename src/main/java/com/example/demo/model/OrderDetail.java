package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "orderdetail")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "product_detail_id")
    private Integer product_detail_id;
    @Column(name = "order_id")
    private Integer order_id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Integer price;
}
