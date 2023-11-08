package com.example.demo.service.ProductDetail;

import com.example.demo.model.ProductDetail;
import com.example.demo.repository.IProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    private IProductDetailRepository repository;

    @Override
    public List<ProductDetail> getAll() {
        return repository.findAll();
    }

    @Override
    public ProductDetail getById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
