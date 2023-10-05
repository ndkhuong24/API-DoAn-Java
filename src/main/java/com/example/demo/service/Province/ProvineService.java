package com.example.demo.service.Province;

import com.example.demo.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProvineService {
    List<Province> getAll();
    void add(List<Province> list);
    void delete(Integer id);
}
