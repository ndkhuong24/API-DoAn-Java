package com.example.demo.repository;

import com.example.demo.model.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerAddressRepository extends JpaRepository<CustomerAddress,Integer> {
}
