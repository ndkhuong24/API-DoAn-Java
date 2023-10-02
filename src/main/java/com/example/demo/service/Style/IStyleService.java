package com.example.demo.service.Style;

import com.example.demo.model.Material;
import com.example.demo.model.Style;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStyleService {
    Page<Style> getAllPage(Pageable pageable);
    void add(Style style);
    void update(Style style);
    void delete(Integer id);
    Style getStyleById(Integer id);
}
