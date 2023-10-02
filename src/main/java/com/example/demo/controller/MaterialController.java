package com.example.demo.controller;

import com.example.demo.model.Material;
import com.example.demo.model.Size;
import com.example.demo.service.Material.IMaterialService;
import com.example.demo.service.Size.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/material")
public class MaterialController {
    @Autowired
    private IMaterialService service;
    Page<Material> sizePage;
    @GetMapping
    public ResponseEntity<List<Material>> getAllPage(@RequestParam(defaultValue = "1")int page){
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        sizePage = service.getAllPage(pageable);
        return ResponseEntity.ok(sizePage.getContent());

    }
    @PostMapping
    public ResponseEntity<Material> postSize(@RequestBody Material material){
        service.add(material);
        return ResponseEntity.ok(material);
    }
    @PutMapping
    public ResponseEntity<Material> putBrand(@RequestBody Material material) {
        service.update(material);
        return ResponseEntity.ok(material);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
