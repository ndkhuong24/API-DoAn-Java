package com.example.demo.service.Province;

import com.example.demo.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProvineService {
    Page<Province> getAll(Pageable pageable);
    void add(List<Province> list);
    void delete(Integer id);
}
