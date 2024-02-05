package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer id;
    private String code;
    private String name;
    private String style_id;
    private String brand_id;
    private String category_id;
    private String description;
    private Date createDate;
    private Integer status;
}
