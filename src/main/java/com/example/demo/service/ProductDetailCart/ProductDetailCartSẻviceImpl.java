package com.example.demo.service.ProductDetailCart;

import com.example.demo.model.ProductDetailCart;
import com.example.demo.repository.IProductDeyailCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailCartSẻviceImpl implements ProductDetailCartService{
    @Autowired
    private IProductDeyailCartRepository repository;
    @Override
    public ProductDetailCart getOne(Integer product, String size, String color, String material, String sole) {
        return repository.getOne(product, size, color, material, sole);
    }
}
