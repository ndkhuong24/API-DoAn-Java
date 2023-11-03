package com.example.demo.controller;

import com.example.demo.model.ImageChinh;
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
    Page<ImageChinh> imagePage;

    @GetMapping("/getAll")
    public ResponseEntity<List<ImageChinh>>getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/product_detail_id/{id}")
    public ResponseEntity<ImageChinh>GetByProduct_id(@PathVariable Integer id){
        return ResponseEntity.ok(service.getByProduct_detail_id(id));
    }

    @GetMapping
    public ResponseEntity<List<ImageChinh>> getAllPage(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        imagePage = service.getAllPage(pageable);
        return ResponseEntity.ok(imagePage.getContent());
    }

    @PostMapping
    public ResponseEntity<ImageChinh> postImage(@RequestBody ImageChinh imageChinh) {
        service.add(imageChinh);
        return ResponseEntity.ok(imageChinh);
    }

    @PutMapping
    public ResponseEntity<ImageChinh> putImage(@RequestBody ImageChinh imageChinh) {
        service.update(imageChinh);
        return ResponseEntity.ok(imageChinh);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
