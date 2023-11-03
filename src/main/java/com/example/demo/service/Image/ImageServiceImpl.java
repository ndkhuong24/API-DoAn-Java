package com.example.demo.service.Image;

import com.example.demo.model.ImageChinh;
import com.example.demo.repository.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private IImageRepository repository;

    @Override
    public Page<ImageChinh> getAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(ImageChinh imageChinh) {
        repository.save(imageChinh);
    }

    @Override
    public void update(ImageChinh imageChinh) {
        repository.save(imageChinh);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ImageChinh getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public List<ImageChinh> getAll() {
        return repository.findAll();
    }

    @Override
    public ImageChinh getByProduct_detail_id(Integer id) {
        return repository.findbyProduct_detail_id(id);
    }
}
