package com.example.demo.service.District;

import com.example.demo.model.District;
import com.example.demo.repository.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private IDistrictRepository repository;

    @Override
    public Page<District> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(List<District> list) {
        repository.saveAll(list);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
