package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Color;
import com.example.demo.service.Color.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Color")
public class ColorController {
    @Autowired
    private ColorService service;

    Page<Color> colorPage;

    @GetMapping
    public ResponseEntity<List<Color>> getAllPage(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        colorPage = service.getAllPage(pageable);
        return ResponseEntity.ok(colorPage.getContent());
    }

    @PostMapping
    public ResponseEntity<Color> postColor(@RequestBody Color color) {
        service.add(color);
        return ResponseEntity.ok(color);
    }

    @PutMapping
    public ResponseEntity<Color> putColor(@RequestBody Color color) {
        service.update(color);
        return ResponseEntity.ok(color);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteColor(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
