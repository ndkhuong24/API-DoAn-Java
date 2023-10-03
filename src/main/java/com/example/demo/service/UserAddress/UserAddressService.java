package com.example.demo.service.UserAddress;

import com.example.demo.model.UserAdrdess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserAddressService {
    Page<UserAdrdess> getAll(Pageable pageable);
    void add(UserAdrdess userAdrdess);
    void delete(Integer id);
}
