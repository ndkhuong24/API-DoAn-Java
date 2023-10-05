package com.example.demo.service.Province;

import com.example.demo.model.Province;
import com.example.demo.repository.IProvineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvineService {
    @Autowired
    private IProvineRepository repository;

    @Override
    public List<Province> getAll() {
        return repository.findAll();
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
