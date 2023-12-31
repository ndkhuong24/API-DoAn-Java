package com.example.demo.service.Material;

import com.example.demo.model.Material;
import com.example.demo.repository.IMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Material> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Material> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Material> getAllMaterialActive() {
        return repository.getAllMaterialActive();
    }

    @Override
    public List<Material> findByProduct(Integer id) {
        return repository.finbyProduct(id);
    }
}
