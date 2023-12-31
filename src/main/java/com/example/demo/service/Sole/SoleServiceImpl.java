package com.example.demo.service.Sole;

import com.example.demo.model.Sole;
import com.example.demo.repository.ISoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoleServiceImpl implements SoleService {
    @Autowired
    private ISoleRepository repository;

    @Override
    public Page<Sole> getAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(Sole sole) {
        repository.save(sole);
    }

    @Override
    public void update(Sole sole) {
        repository.save(sole);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Sole getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Sole> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Sole> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Sole> getAllSoleActive() {
        return repository.getAllSoleActive();
    }

    @Override
    public List<Sole> findByProduct(Integer id) {
        return repository.findByProduct(id);
    }


}
