package com.example.demo.Controller;

import com.example.demo.Model.District;

import com.example.demo.Repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictRepository repository;

    @GetMapping
    public ResponseEntity<List<District>> DisgetAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
