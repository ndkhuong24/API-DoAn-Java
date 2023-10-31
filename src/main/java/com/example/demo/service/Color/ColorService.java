package com.example.demo.service.Color;

import com.example.demo.model.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ColorService {
    Page<Color> getAllPage(Pageable pageable);

    void add(Color color);

    void update(Color color);

    void delete(Integer id);

    List<Color> getAll();
}
