package com.example.demo.repository;

import com.example.demo.model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommuneRepository extends JpaRepository<Commune,Integer> {
}
