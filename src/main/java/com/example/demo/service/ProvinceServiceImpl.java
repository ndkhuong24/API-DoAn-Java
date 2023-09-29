package com.example.demo.service;

import com.example.demo.model.Province;
import com.example.demo.repository.ProvineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvineService {
    @Autowired
    private ProvineRepository repository;

    @Override
    public List<Province> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(List<Province> list) {
        repository.saveAll(list);
    }


}
