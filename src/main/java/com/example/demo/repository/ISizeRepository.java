package com.example.demo.repository;

import com.example.demo.model.Brand;
import com.example.demo.model.Size;
import com.example.demo.model.Sole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISizeRepository extends JpaRepository<Size,Integer> {
    @Query(value = "SELECT * FROM Size WHERE name LIKE %?1%",nativeQuery = true)
    List<Size> findByName(String name);
}
