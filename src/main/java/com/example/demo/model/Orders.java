package com.example.demo.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "orders")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "date_create")
    private Date date_create;
    @Column(name = "total_price")
    private Integer total_price;
    @Column(name = "transport_fee")
    private Integer transport_fee;
    @Column(name = "description_order")
    private String description_order;
    @Column(name = "voucher_id")
    private Integer voucher_id;
    @Column(name = "discount_price")
    private Integer discount_price;
    @Column(name = "final_price")
    private Integer final_price;
    @Column(name = "status")
    private Integer status;

    public Orders(Integer id) {
        this.id = id;
    }
}
