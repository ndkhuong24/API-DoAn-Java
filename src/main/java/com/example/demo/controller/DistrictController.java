package com.example.demo.controller;

import com.example.demo.model.District;
import com.example.demo.service.District.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/District")
@CrossOrigin("*")
public class DistrictController {
    @Autowired
    private DistrictService service;

    private List<District> districtList;

    @GetMapping
    public ResponseEntity<List<District>> getAllPage() {
        districtList = service.getAll();
        return ResponseEntity.ok(districtList);
    }

    @PostMapping
    public ResponseEntity<List<District>> add(@RequestBody List<District> list) {
        service.add(list);
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
