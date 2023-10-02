package com.example.demo.service.Material;

import com.example.demo.model.Material;
import com.example.demo.model.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMaterialService {
    Page<Material> getAllPage(Pageable pageable);
    void add(Material material);
    void update(Material material);
    void delete(Integer id);
    Material getMaterialById(Integer id);
}
