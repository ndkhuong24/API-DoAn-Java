package com.example.demo.service.Image;

import com.example.demo.model.ImageChinh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ImageService {
    Page<ImageChinh> getAllPage(Pageable pageable);
    void add(ImageChinh imageChinh);
    void update(ImageChinh imageChinh);
    void delete(Integer id);
    ImageChinh getById(Integer id);
    List<ImageChinh> getAll();
    ImageChinh getByProduct_detail_id(Integer id);
}
