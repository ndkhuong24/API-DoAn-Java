package com.example.demo.repository;

import com.example.demo.model.Sole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoleRepository extends JpaRepository<Sole,Integer> {
}
