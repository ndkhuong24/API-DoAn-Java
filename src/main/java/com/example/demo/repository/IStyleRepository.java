package com.example.demo.repository;

import com.example.demo.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStyleRepository extends JpaRepository<Style,Integer> {
}
