package com.example.demo.repository;

import com.example.demo.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDistrictRepository extends JpaRepository<District,Integer> {
}
