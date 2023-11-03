package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Product")
public class ProductController {
    @Autowired
    private ProductService service;

    List<Product> list = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Product>>getAll(){
        list=service.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){

        return ResponseEntity.ok(service.findById(id));
    }
}
