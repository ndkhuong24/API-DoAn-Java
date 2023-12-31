package com.example.demo.service.customer;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> getAllPage(Pageable pageable);
    void add(Customer customer);
    void update(Customer customer);
    void delete(Integer id);
    Customer getById(Integer id);
    Customer getByUsername(String username);
}
