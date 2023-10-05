package com.example.demo.controller;

import com.example.demo.model.Commune;
import com.example.demo.service.Commune.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Commune")
@CrossOrigin("*")
public class CommuneController {
    @Autowired
    private CommuneService service;

    private List<Commune> communeList;

    @GetMapping
    public ResponseEntity<List<Commune>> getAllPage() {
        communeList = service.getAll();
        return ResponseEntity.ok(communeList);
    }

    @PostMapping
    public ResponseEntity<List<Commune>> add(@RequestBody List<Commune> list) {
        service.add(list);
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
