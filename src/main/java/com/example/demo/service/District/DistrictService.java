package com.example.demo.service.District;

import com.example.demo.model.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DistrictService {
    List<District> getAll();

    void add(List<District> list);

    void delete(Integer id);
}
