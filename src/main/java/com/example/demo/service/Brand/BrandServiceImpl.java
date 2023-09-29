package com.example.demo.service.Brand;

import com.example.demo.model.Brand;
import com.example.demo.repository.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private IBrandRepository repository;

    @Override
    public Page<Brand> getAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(Brand brand) {
        repository.save(brand);
    }

    @Override
    public void update(Brand brand) {
        repository.save(brand);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Brand getBrandById(Integer id) {
        return repository.getOne(id);
    }
}
