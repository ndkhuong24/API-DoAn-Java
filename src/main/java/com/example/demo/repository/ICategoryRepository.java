package com.example.demo.repository;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "SELECT * FROM Category WHERE name LIKE %?1%",nativeQuery = true)
    List<Category> findByName(String name);

    @Query(value = "SELECT * FROM Category WHERE [status]=1",nativeQuery = true)
    List<Category> getAllActiveCategory();
}
