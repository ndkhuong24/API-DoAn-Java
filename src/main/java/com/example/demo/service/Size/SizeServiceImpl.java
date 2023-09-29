package com.example.demo.service.Size;

import com.example.demo.model.Size;
import com.example.demo.repository.ISizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImpl implements ISizeService{
    @Autowired
    private ISizeRepository repository;

    @Override
    public Page<Size> getAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(Size size) {
        repository.save(size);
    }

    @Override
    public void update(Size size) {
        repository.save(size);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Size getBrandById(Integer id) {
        return repository.getOne(id);
    }
}
