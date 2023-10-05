package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.service.Address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Address")
public class AddressController {
    @Autowired
    private AddressService service;

    private List<Address> addressList;

    @GetMapping
    public ResponseEntity<List<Address>> getAllPage() {
        addressList = service.getAll();
        return ResponseEntity.ok(addressList);
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
