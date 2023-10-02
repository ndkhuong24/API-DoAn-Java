package com.example.demo.service.Size;

import com.example.demo.model.Brand;
import com.example.demo.model.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISizeService {
    Page<Size> getAllPage(Pageable pageable);
    void add(Size size);
    void update(Size size);
    void delete(Integer id);
    Size getSizeById(Integer id);
}
