package com.example.demo.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "imagechinh")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageChinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "path")
    private String path;

    @Column(name = "product_detail_id")
    private Integer product_detail_id;


}
