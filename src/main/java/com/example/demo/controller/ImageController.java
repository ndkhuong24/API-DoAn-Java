package com.example.demo.controller;

import com.example.demo.model.Image;
import com.example.demo.service.Image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Image")
public class ImageController {
    @Autowired
    private ImageService service;
    Page<Image> imagePage;

    @GetMapping
    public ResponseEntity<List<Image>> getAllPage(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        imagePage = service.getAllPage(pageable);
        return ResponseEntity.ok(imagePage.getContent());
    }

    @PostMapping
    public ResponseEntity<Image> postImage(@RequestBody Image image) {
        service.add(image);
        return ResponseEntity.ok(image);
    }

    @PutMapping
    public ResponseEntity<Image> putImage(@RequestBody Image image) {
        service.update(image);
        return ResponseEntity.ok(image);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
