package com.example.demo.controller;

import com.example.demo.model.Brand;
import com.example.demo.service.Brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Brand")
public class BrandController {
    @Autowired
    private BrandService service;
    Page<Brand> brandPage;

    @GetMapping("/getAll")
    public ResponseEntity<List<Brand>> getAllBrand() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/getAll/active")
    public ResponseEntity<List<Brand>> getAllBrandActive() {
        return ResponseEntity.ok(service.getAllBrandActive());
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getAllPage(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        brandPage = service.getAllPage(pageable);
        return ResponseEntity.ok(brandPage.getContent());

    }

    @PostMapping
    public ResponseEntity<Brand> postBrand(@RequestBody Brand brand) {
        service.add(brand);
        return ResponseEntity.ok(brand);
    }

    @PutMapping
    public ResponseEntity<Brand> putBrand(@RequestBody Brand brand) {
        service.update(brand);
        return ResponseEntity.ok(brand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Brand>> searchBrand(@PathVariable String name) {
        List<Brand> brand = service.findByName(name);
        return ResponseEntity.ok(brand);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Brand> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getById(id));
    }
}
