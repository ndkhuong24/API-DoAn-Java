package com.example.demo.service.Size;

import com.example.demo.model.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SizeService {
    Page<Size> getAllPage(Pageable pageable);

    void add(Size size);

    void update(Size size);

    void delete(Integer id);

    Size getById(Integer id);

    List<Size> getAll();

    List<Size> findByName(String name);

    List<Size> getAllSizeActive();

    List<Size> findByProduct(Integer id);
}
