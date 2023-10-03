package com.example.demo.repository;

import com.example.demo.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvineRepository extends JpaRepository<Province,Integer> {
}
