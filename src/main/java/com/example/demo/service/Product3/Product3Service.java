package com.example.demo.service.Product3;

import com.example.demo.model.Product3;

import java.util.List;

public interface Product3Service {
    List<Product3> getAll();

    Product3 getById(Integer id);
}
