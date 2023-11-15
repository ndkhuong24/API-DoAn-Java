package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.Name;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Filter {
    @Id
    @Column(name = "id")
    private Integer id;

    private String categoryName;

    private String brandName;

    private String productName;

    private String sizeName;

    private String colorName;

    private String soleName;

    private String materialName;

    private Integer price;

    private String path;

}
