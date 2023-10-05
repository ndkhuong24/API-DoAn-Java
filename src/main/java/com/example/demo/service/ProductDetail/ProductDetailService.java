package com.example.demo.service.ProductDetail;

import com.example.demo.model.ProductDetail;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetail> getAll();

    ProductDetail getById(Integer id);
}
