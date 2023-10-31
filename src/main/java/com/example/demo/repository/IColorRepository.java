package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IColorRepository extends JpaRepository<Color, Integer> {
    @Query(value = "SELECT * FROM Color WHERE name LIKE %?1%",nativeQuery = true)
    List<Color> findByName(String name);
}
