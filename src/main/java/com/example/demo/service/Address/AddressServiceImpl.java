package com.example.demo.service.Address;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRespository respository;

    @Override
    public Page<Address> getAll(Pageable pageable) {
        return respository.findAll(pageable);
    }

    @Override
    public void add(List<Address> list) {
        respository.saveAll(list);
    }

    @Override
    public void delete(Integer id) {
        respository.deleteById(id);
    }
}
