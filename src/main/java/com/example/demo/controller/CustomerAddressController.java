package com.example.demo.controller;

import com.example.demo.model.CustomerAddress;
import com.example.demo.service.CustomerAddress.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/CustomerAddress")
public class CustomerAddressController {
    @Autowired
    private CustomerAddressService service;

    private Page<CustomerAddress> CustomerAddressPage;

    @GetMapping
    public ResponseEntity<List<CustomerAddress>>getAll(@RequestParam(defaultValue = "1")int page){
        if(page<1)page=1;
        int pageNum = page-1;
        int pageSize =5;
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        CustomerAddressPage = service.getAll(pageable);
        return ResponseEntity.ok(CustomerAddressPage.getContent());
    }
    @PostMapping
    public ResponseEntity<CustomerAddress> add(@RequestBody CustomerAddress customerAddress){
        service.add(customerAddress);
        return ResponseEntity.ok(customerAddress);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
