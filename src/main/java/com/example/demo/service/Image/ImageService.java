package com.example.demo.service.Image;

import com.example.demo.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ImageService {
    Page<Image> getAllPage(Pageable pageable);
    void add(Image image);
    void update(Image image);
    void delete(Integer id);
    Image getById(Integer id);
}
