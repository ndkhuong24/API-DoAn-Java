package com.example.demo.service.CustomerAddress;

import com.example.demo.model.CustomerAddress;
import com.example.demo.repository.ICustomerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {
    @Autowired
    private ICustomerAddressRepository repository;

    @Override
    public Page<CustomerAddress> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(CustomerAddress customerAddress) {
        repository.save(customerAddress);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
