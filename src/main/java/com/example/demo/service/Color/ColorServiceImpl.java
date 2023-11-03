package com.example.demo.service.Color;

import com.example.demo.model.Color;
import com.example.demo.repository.IColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private IColorRepository repository;

    @Override
    public Page<Color> getAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(Color color) {
        repository.save(color);
    }

    @Override
    public void update(Color color) {
        repository.save(color);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Color> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Color> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Color> getAllColorActive() {
        return repository.getAllColorActive();
    }
}
