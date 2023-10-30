package com.example.demo.controller;

import com.example.demo.model.ConfirmOrders;
import com.example.demo.service.ConfirmOrders.ConfirmOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/Confirm")
public class ConfirmOrderController {
    @Autowired
    ConfirmOrderService confirmOrderService;

    @PostMapping
    public ResponseEntity<ConfirmOrders> add(@RequestBody ConfirmOrders confirmOrders){
        confirmOrderService.confirm(confirmOrders);
        return ResponseEntity.ok(confirmOrders);
    }
}
