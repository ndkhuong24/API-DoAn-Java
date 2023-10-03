package com.example.demo.service.Image;

import com.example.demo.model.Image;
import com.example.demo.repository.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private IImageRepository repository;

    @Override
    public Page<Image> getAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(Image image) {
        repository.save(image);
    }

    @Override
    public void update(Image image) {
        repository.save(image);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Image getById(Integer id) {
        return repository.getOne(id);
    }
}
