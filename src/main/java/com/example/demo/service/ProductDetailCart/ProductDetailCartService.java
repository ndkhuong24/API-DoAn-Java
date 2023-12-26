package com.example.demo.service.ProductDetailCart;

import com.example.demo.model.ProductDetailCart;

import java.util.List;

public interface ProductDetailCartService {
    ProductDetailCart getOne(Integer product,String size,String color,String material,String sole);
}
