package com.example.demo.service.Brand;

import com.example.demo.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBrandService {
    Page<Brand> getAllPage(Pageable pageable);
    void add(Brand brand);
    void update(Brand brand);
    void delete(Integer id);
    Brand getBrandById(Integer id);
}
