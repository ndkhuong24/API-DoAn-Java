package com.example.demo.service.Sole;

import com.example.demo.model.Sole;
import com.example.demo.model.Style;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SoleService {
    Page<Sole> getAllPage(Pageable pageable);
    void add(Sole sole);
    void update(Sole sole);
    void delete(Integer id);
    Sole getById(Integer id);

    List<Sole> getAll();
}
