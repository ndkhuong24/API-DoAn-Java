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

    private Page<District> districtPage;

    @GetMapping
    public ResponseEntity<List<District>> getAllPage(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        districtPage = service.getAll(pageable);
        return ResponseEntity.ok(districtPage.getContent());
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
