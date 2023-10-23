package com.example.demo.repository;

import com.example.demo.dto.ERole;
import com.example.demo.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IRoleRepository extends JpaRepository<Roles,Integer> {
    Optional<Roles>findByName(ERole name);
}
