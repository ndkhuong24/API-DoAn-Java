package com.example.demo.service.Category;

import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> getAllPage(Pageable pageable);

    void add(Category category);

    void update(Category category);

    void delete(Integer id);
}
