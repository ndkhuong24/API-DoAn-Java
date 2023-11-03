package com.example.demo.service.Product;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    List<Product> getAll();
    Product findById(Integer id);
}
