package com.example.demo.controller;

import com.example.demo.model.Orders;
import com.example.demo.service.Orders.OrdersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Orders")
@CrossOrigin("*")
public class OrdersController {
    @Autowired
    private OrdersService service;

    private Page<Orders> ordersPage;

    @GetMapping
    public ResponseEntity<List<Orders>> getAll(@RequestParam(defaultValue = "1")int page){
        if(page<1) page=1;
        int pageNum = page-1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        ordersPage=service.getAll(pageable);
        return ResponseEntity.ok(ordersPage.getContent());
    }
    @PostMapping
    public  ResponseEntity<Orders> add(@RequestBody Orders orders){
        service.add(orders);
        return ResponseEntity.ok(orders);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
