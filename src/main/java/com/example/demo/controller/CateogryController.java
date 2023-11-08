package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Category")
public class CateogryController {
    @Autowired
    private CategoryService service;
    Page<Category> categoryPage;

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> getAllCategory() {
        return ResponseEntity.ok(service.getAllCategory());
    }

    @GetMapping("/getAll/active")
    public ResponseEntity<List<Category>> getAllActiveCategory() {
        return ResponseEntity.ok(service.getAllActiveCategory());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findbyId(id));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllPage(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        categoryPage = service.getAllPage(pageable);
        return ResponseEntity.ok(categoryPage.getContent());
    }

    @PostMapping
    public ResponseEntity<Category> postCategory(@RequestBody Category category) {
        service.add(category);
        return ResponseEntity.ok(category);
    }

    @PutMapping
    public ResponseEntity<Category> putCategory(@RequestBody Category category) {
        service.update(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Category>> getCategory(@PathVariable String name) {
        List<Category> category = service.findByName(name);
        return ResponseEntity.ok(category);
    }
}
