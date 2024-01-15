package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import com.example.demo.model.Users;
import com.example.demo.service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getDS(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ProductDTO> phieuGiaoHangs = productService.getAll(pageable);
        return ResponseEntity.ok(phieuGiaoHangs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){

        return ResponseEntity.ok(productService.findById(id));
    }
}
