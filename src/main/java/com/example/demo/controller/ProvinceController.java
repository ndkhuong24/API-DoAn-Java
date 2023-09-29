package com.example.demo.controller;

import com.example.demo.model.Province;
import com.example.demo.service.ProvineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/province")
@CrossOrigin("*")
public class ProvinceController {
    @Autowired
    private ProvineService service;

    private List<Province> list = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Province>> getAll(){
       list= service.getAll();

        return ResponseEntity.ok(list);
    }
}
