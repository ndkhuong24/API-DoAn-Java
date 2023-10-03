package com.example.demo.service.Material;

import com.example.demo.model.Material;
import com.example.demo.repository.IMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private IMaterialRepository repository;
    @Override
    public Page<Material> getAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(Material material) {
        repository.save(material);
    }

    @Override
    public void update(Material material) {
        repository.save(material);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Material getById(Integer id) {
        return repository.getOne(id);
    }
}
