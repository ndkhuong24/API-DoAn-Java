package com.example.demo.service.UserAddress;

import com.example.demo.model.UserAdrdess;
import com.example.demo.repository.ICustomerAddressRepository;
import com.example.demo.repository.IUserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserAddressServiceImpl implements UserAddressService{
    @Autowired
    private IUserAddressRepository repository;
    @Override
    public Page<UserAdrdess> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(UserAdrdess userAdrdess) {
        repository.save(userAdrdess);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
