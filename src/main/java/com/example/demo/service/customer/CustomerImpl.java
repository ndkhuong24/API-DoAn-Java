package com.example.demo.service.customer;

import com.example.demo.model.Customer;
import com.example.demo.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> getAllPage(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void add(Customer sole) {
        customerRepository.save(sole);
    }

    @Override
    public void update(Customer sole) {
        customerRepository.save(sole);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer getById(Integer id) {
        return customerRepository.getOne(id);
    }
}
