package com.example.demo.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_id")
    private Integer customer_id;

    @Column(name = "product_detail_id")
    private Integer product_detail_id;

    @Column(name = "point")
    private Integer point;

    @Column(name = "comment")
    private String comment;
}
