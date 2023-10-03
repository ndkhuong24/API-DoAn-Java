package com.example.demo.controller;

import com.example.demo.model.Sole;
import com.example.demo.service.Sole.SoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Sole")
public class SoleController {
    @Autowired
    private SoleService service;
    Page<Sole> solePage;

    @GetMapping
    public ResponseEntity<List<Sole>> getAllPage(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        solePage = service.getAllPage(pageable);
        return ResponseEntity.ok(solePage.getContent());

    }

    @PostMapping
    public ResponseEntity<Sole> postSole(@RequestBody Sole sole) {
        service.add(sole);
        return ResponseEntity.ok(sole);
    }

    @PutMapping
    public ResponseEntity<Sole> putSole(@RequestBody Sole sole) {
        service.update(sole);
        return ResponseEntity.ok(sole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSole(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}