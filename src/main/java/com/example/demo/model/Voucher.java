package com.example.demo.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "voucher")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private Integer type;
    @Column(name = "value")
    private Float value;
    @Column(name = "maximum_value")
    private Integer maximum_value;
    @Column(name = "condition_value")
    private Integer condition_value;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "start_date")
    private LocalDateTime start_date;
    @Column(name = "end_date")
    private LocalDateTime end_date;
//    @Column(name = "status")
//    private Integer status;
}
