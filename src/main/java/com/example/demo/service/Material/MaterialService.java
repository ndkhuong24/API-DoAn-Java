package com.example.demo.service.Material;

import com.example.demo.model.Material;
import com.example.demo.model.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MaterialService {
    Page<Material> getAllPage(Pageable pageable);

    void add(Material material);

    void update(Material material);

    void delete(Integer id);

    Material getById(Integer id);

    List<Material> getAll();
}
