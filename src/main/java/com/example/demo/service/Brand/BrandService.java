package com.example.demo.service.Brand;

import com.example.demo.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandService {
    Page<Brand> getAllPage(Pageable pageable);
    void add(Brand brand);
    void update(Brand brand);
    void delete(Integer id);
    Brand getById(Integer id);
    List<Brand> getAll();
    List<Brand> findByName(String name);
}
