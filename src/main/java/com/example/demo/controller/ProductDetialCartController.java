package com.example.demo.controller;

import com.example.demo.model.ProductDetailCart;
import com.example.demo.service.ProductDetailCart.ProductDetailCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/ProductDetail")
public class ProductDetialCartController {
    @Autowired
    private ProductDetailCartService service;

    @GetMapping("/getOne/{product}/{size}/{color}/{material}/{sole}")
    public ResponseEntity<ProductDetailCart>GetOne(@PathVariable Integer product,
                                                         @PathVariable String size,
                                                         @PathVariable String color,
                                                         @PathVariable String material,
                                                         @PathVariable String sole){
        return ResponseEntity.ok(service.getOne(product, size, color, material, sole));
    }
}
