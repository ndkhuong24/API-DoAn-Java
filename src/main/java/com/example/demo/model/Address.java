package com.example.demo.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "detail_address")
    private String detail_address;

    @Column(name = "commune_id")
    private Integer commune_id;

    @Column(name = "district_id")
    private Integer district_id;

    @Column(name = "province_id")
    private Integer province_id;
}
