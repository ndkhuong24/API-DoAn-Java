package com.example.demo.controller;

import com.example.demo.model.Product3;
import com.example.demo.repository.IProduct3Respository;
import com.example.demo.service.Product3.Product3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Product3")
public class Product3Controller {
    @Autowired
    private Product3Service service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Product3>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product3> getById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getById(id));
    }
}
