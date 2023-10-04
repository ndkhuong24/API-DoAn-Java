package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.Order.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService service;

    private Page<Order> OrderPage;

    @GetMapping
    public ResponseEntity<List<Order>> getAll(@RequestParam(defaultValue = "1")int page){
        if(page<1) page=1;
        int pageNum = page-1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        OrderPage=service.getAll(pageable);
        return ResponseEntity.ok(OrderPage.getContent());
    }
    @PostMapping
    public  ResponseEntity<Order> add(@RequestBody Order order){
        service.add(order);
        return ResponseEntity.ok(order);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
