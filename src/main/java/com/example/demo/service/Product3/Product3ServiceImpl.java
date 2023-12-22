package com.example.demo.service.Product3;

import com.example.demo.model.Product3;
import com.example.demo.repository.IProduct3Respository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Product3ServiceImpl implements Product3Service{
    @Autowired
    private IProduct3Respository respository;

    @Override
    public List<Product3> getAll() {
        return respository.getAll();
    }

    @Override
    public Product3 getById(Integer id) {
        return respository.getById(id);
    }
}
