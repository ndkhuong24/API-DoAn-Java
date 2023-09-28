package com.example.demo.Controller;

import com.example.demo.Model.Brand;
import com.example.demo.Repository.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/brand")
public class BrandController {
    @Autowired
    private IBrandRepository repository;
    @GetMapping
    public ResponseEntity<List<Brand>> getAll() {
        List<Brand> list = repository.findAll();
        return ResponseEntity.ok(list);
    }
}
