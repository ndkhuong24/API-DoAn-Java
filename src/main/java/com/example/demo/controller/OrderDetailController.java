package com.example.demo.controller;

import com.example.demo.model.OrderDetail;
import com.example.demo.service.OrderDetail.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/OrderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService service;

    private Page<OrderDetail> OrderDetailPage;

    @GetMapping
    public ResponseEntity<List<OrderDetail>> getAll(@RequestParam(defaultValue = "1")int page){
        if(page<1) page=1;
        int pageNum=page-1;
        int pageSize=5;
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        OrderDetailPage=service.getAll(pageable);
        return ResponseEntity.ok(OrderDetailPage.getContent());
    }
    @PostMapping
    public ResponseEntity<OrderDetail> add(@RequestBody OrderDetail orderDetail){
        service.add(orderDetail);
        return ResponseEntity.ok(orderDetail);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
