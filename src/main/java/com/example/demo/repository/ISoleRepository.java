package com.example.demo.repository;

import com.example.demo.model.Sole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISoleRepository extends JpaRepository<Sole,Integer> {
    @Query(value = "SELECT * FROM Sole WHERE name LIKE %?1%",nativeQuery = true)
    List<Sole> findByName(String name);

    @Query(value = "SELECT * FROM Sole WHERE [status]=1",nativeQuery = true)
    List<Sole> getAllSoleActive();
}
