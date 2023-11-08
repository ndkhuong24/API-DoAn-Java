package com.example.demo.controller;

import com.example.demo.model.Material;
import com.example.demo.service.Material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Material")
public class MaterialController {
    @Autowired
    private MaterialService service;
    Page<Material> materialPage;

    @GetMapping("/{name}")
    public ResponseEntity<List<Material>> searchByName(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Material> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Material>> getAllMaterial() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/getAll/active")
    public ResponseEntity<List<Material>> getAllMaterialActive() {
        return ResponseEntity.ok(service.getAllMaterialActive());
    }

    @GetMapping
    public ResponseEntity<List<Material>> getAllPage(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        materialPage = service.getAllPage(pageable);
        return ResponseEntity.ok(materialPage.getContent());

    }

    @PostMapping
    public ResponseEntity<Material> postSize(@RequestBody Material material) {
        service.add(material);
        return ResponseEntity.ok(material);
    }

    @PutMapping
    public ResponseEntity<Material> putBrand(@RequestBody Material material) {
        service.update(material);
        return ResponseEntity.ok(material);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
