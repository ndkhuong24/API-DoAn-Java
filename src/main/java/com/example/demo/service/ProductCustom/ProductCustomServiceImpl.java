package com.example.demo.service.ProductCustom;

import com.example.demo.model.ProductCustom;
import com.example.demo.repository.IProductCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCustomServiceImpl implements ProductCustomService {
    @Autowired
    private IProductCustomRepository repository;

    @Override
    public void add(ProductCustom productCustom) {
        repository.add(productCustom);
    }
}
