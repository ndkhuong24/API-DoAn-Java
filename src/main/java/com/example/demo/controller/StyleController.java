package com.example.demo.controller;

import com.example.demo.model.Product3;
import com.example.demo.model.Style;
import com.example.demo.repository.IStyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Style")
public class StyleController {
    @Autowired
    IStyleRepository styleRepository;
    @GetMapping()
    public ResponseEntity<List<Style>> getAll(){
        return ResponseEntity.ok(styleRepository.findAll());
    }
}
