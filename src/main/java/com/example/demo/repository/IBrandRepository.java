package com.example.demo.repository;

import com.example.demo.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<Brand,Integer> {
}
