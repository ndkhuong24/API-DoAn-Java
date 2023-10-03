package com.example.demo.controller;

import com.example.demo.model.ProductDetail;
import com.example.demo.service.ProductDetail.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
