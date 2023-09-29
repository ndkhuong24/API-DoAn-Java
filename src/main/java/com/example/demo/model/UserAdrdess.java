package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "useraddress")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAdrdess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "address_id")
    private Integer address_id;
    @Column(name = "status")
    private Integer status;
}
