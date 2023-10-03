package com.example.demo.service.CustomerAddress;

import com.example.demo.model.CustomerAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerAddressService {
    Page<CustomerAddress> getAll(Pageable pageable);
    void add(CustomerAddress customerAddress);
    void delete(Integer id);
}
