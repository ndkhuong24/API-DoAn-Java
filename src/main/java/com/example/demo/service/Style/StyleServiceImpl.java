package com.example.demo.service.Style;

import com.example.demo.model.Material;
import com.example.demo.model.Style;
import com.example.demo.repository.IMaterialRepository;
import com.example.demo.repository.IStyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StyleServiceImpl implements IStyleService {
    @Autowired
    private IStyleRepository repository;
    @Override
    public Page<Style> getAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(Style style) {
        repository.save(style);
    }

    @Override
    public void update(Style style) {
        repository.save(style);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Style getStyleById(Integer id) {
        return repository.getOne(id);
    }
}
