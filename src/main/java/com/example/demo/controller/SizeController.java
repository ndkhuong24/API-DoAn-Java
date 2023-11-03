package com.example.demo.controller;

import com.example.demo.model.Size;
import com.example.demo.service.Size.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Size")
public class SizeController {
    @Autowired
    private SizeService service;
    Page<Size> sizePage;

    @GetMapping("/{name}")
    public ResponseEntity<List<Size>> search(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Size>> getAllSize() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/getAll/active")
    public ResponseEntity<List<Size>> getAllSizeActive() {
        return ResponseEntity.ok(service.getAllSizeActive());
    }

    @GetMapping
    public ResponseEntity<List<Size>> getAllPage(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        sizePage = service.getAllPage(pageable);
        return ResponseEntity.ok(sizePage.getContent());

    }

    @PostMapping
    public ResponseEntity<Size> postSize(@RequestBody Size size) {
        service.add(size);
        return ResponseEntity.ok(size);
    }

    @PutMapping
    public ResponseEntity<Size> putBrand(@RequestBody Size size) {
        service.update(size);
        return ResponseEntity.ok(size);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
