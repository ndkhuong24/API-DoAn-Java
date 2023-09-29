package com.example.demo.controller;

import com.example.demo.model.Brand;
import com.example.demo.service.Brand.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/brand")
public class BrandController {
    @Autowired
    private IBrandService service;
    Page<Brand> brandPage;
    @GetMapping
    public ResponseEntity<List<Brand>> getAllPage(@RequestParam(defaultValue = "1")int page){
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        brandPage = service.getAllPage(pageable);
        return ResponseEntity.ok(brandPage.getContent());

    }
    @PostMapping
    public ResponseEntity<Brand> postBrand(@RequestBody Brand brand){
        service.add(brand);
        return ResponseEntity.ok(brand);
    }
    @PutMapping
    public ResponseEntity<Brand> putBrand(@RequestBody Brand brand) {
        service.add(brand);
        return ResponseEntity.ok(brand);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteBrand(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
