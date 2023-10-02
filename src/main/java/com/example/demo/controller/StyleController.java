package com.example.demo.controller;

import com.example.demo.model.Size;
import com.example.demo.model.Style;
import com.example.demo.service.Size.ISizeService;
import com.example.demo.service.Style.IStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/style")
public class StyleController {
    @Autowired
    private IStyleService service;
    Page<Style> sizePage;
    @GetMapping
    public ResponseEntity<List<Style>> getAllPage(@RequestParam(defaultValue = "1")int page){
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        sizePage = service.getAllPage(pageable);
        return ResponseEntity.ok(sizePage.getContent());

    }
    @PostMapping
    public ResponseEntity<Style> postSize(@RequestBody Style style){
        service.add(style);
        return ResponseEntity.ok(style);
    }
    @PutMapping
    public ResponseEntity<Style> putBrand(@RequestBody Style style) {
        service.update(style);
        return ResponseEntity.ok(style);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
