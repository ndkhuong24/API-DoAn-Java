package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

//@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Authorities"
//        , uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"Username", "Roleid"})}
)
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne @JoinColumn(name = "user_id")
    private Users user;
    @ManyToOne  @JoinColumn(name = "role_id")
    private Roles role;
}
