package com.example.demo.service.Address;

import com.example.demo.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressService {
    List<Address> getAll();

    void add(List<Address> list);

    void delete(Integer id);
}
