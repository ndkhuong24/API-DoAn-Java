package com.example.demo.service.Commune;

import com.example.demo.model.Commune;
import com.example.demo.repository.ICommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuneServiceIpml implements CommuneService {
    @Autowired
    private ICommuneRepository repository;

    @Override
    public List<Commune> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(List<Commune> list) {
        repository.saveAll(list);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
