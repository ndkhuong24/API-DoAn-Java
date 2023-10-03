package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.service.Address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Address")
public class AddressController {
    @Autowired
    private AddressService service;

    private Page<Address> PageAddress;

    @GetMapping
    public ResponseEntity<List<Address>> getAllPage(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) page = 1;
        int pageNum = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        PageAddress = service.getAll(pageable);
        return ResponseEntity.ok(PageAddress.getContent());
    }

    @PostMapping
    public ResponseEntity<List<Address>> add(@RequestBody List<Address> list) {
        service.add(list);
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
