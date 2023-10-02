package com.example.demo.service.Province;

import com.example.demo.model.Province;
import com.example.demo.repository.ProvineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvineService {
    @Autowired
    private ProvineRepository repository;

    @Override
    public Page<Province> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(List<Province> list) {
        repository.saveAll(list);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
