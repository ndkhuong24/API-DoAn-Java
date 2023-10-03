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
    public ResponseEntity<Category> postCategory(@RequestBody Category category){
        service.add(category);
        return ResponseEntity.ok(category);
    }

    @PutMapping
    public ResponseEntity<Category> putCategory(@RequestBody Category category){
        service.update(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}