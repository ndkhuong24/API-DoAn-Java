package com.example.demo.service.Size;

import com.example.demo.model.Size;
import com.example.demo.repository.ISizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {
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
    public Size getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Size> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Size> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Size> getAllSizeActive() {
        return repository.getAllSizeActive();
    }
}
