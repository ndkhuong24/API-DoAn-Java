package com.example.demo.repository;

import com.example.demo.model.UserAdrdess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAddressRepository extends JpaRepository<UserAdrdess,Integer> {
}
