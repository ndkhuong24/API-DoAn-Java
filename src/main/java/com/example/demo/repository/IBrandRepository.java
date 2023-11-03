package com.example.demo.repository;

import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Integer> {
    @Query(value = "SELECT * FROM Brand WHERE name LIKE %?1%",nativeQuery = true)
    List<Brand> findByName(String name);

    @Query(value = "SELECT * FROM Brand WHERE [status]=1",nativeQuery = true)
    List<Brand> getAllBrandActive();
}
