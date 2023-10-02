package com.example.demo.service.Address;

import com.example.demo.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressService {
    Page<Address> getAll(Pageable pageable);
    void add(List<Address> list);
    void delete(Integer id);
}
