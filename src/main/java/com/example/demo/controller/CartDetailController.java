package com.example.demo.controller;

import com.example.demo.model.CartDetail;
import com.example.demo.service.CartDetail.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CartDetail")
@CrossOrigin("*")
public class CartDetailController {
    @Autowired
    private CartDetailService service;

    private Page<CartDetail> CartDetailPage;

    @GetMapping
    public ResponseEntity<List<CartDetail>> getAll(@RequestParam(defaultValue = "1")int page){
        if(page<1) page=1;
        int pageNum = page-1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        CartDetailPage = service.getALL(pageable);
        return ResponseEntity.ok(CartDetailPage.getContent());
    }
    @PostMapping
    public ResponseEntity<CartDetail> add(@RequestBody CartDetail cartDetail){
        service.add(cartDetail);
        return ResponseEntity.ok(cartDetail);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
