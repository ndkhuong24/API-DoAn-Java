package com.example.demo.controller;

import com.example.demo.model.ProductDetail;
import com.example.demo.service.ProductDetail.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ProductDetail")
public class ProductDetailController {
    @Autowired
    private ProductDetailService service;

    List<ProductDetail> list;

    @GetMapping
    public ResponseEntity<List<ProductDetail>> getAllPage() {
        list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetail> getById(@PathVariable Integer id) {
        ProductDetail productDetail = service.getById(id);
        return ResponseEntity.ok(productDetail);
    }
}
