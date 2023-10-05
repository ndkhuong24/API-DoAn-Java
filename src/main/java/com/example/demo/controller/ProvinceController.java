package com.example.demo.controller;

import com.example.demo.model.Province;
import com.example.demo.service.Province.ProvineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Province")
@CrossOrigin("*")
public class ProvinceController {
    @Autowired
    private ProvineService service;

    private List<Province> provinceList;

    @GetMapping
    public ResponseEntity<List<Province>> getAllPage() {
        provinceList = service.getAll();
        return ResponseEntity.ok(provinceList);
    }

    @PostMapping
    public ResponseEntity<List<Province>> postProvince(@RequestBody List<Province> list) {
        service.add(list);
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProvince(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
