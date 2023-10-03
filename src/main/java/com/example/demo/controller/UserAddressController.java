package com.example.demo.controller;

import com.example.demo.model.UserAdrdess;
import com.example.demo.service.UserAddress.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/UserAddress")
@CrossOrigin("*")
public class UserAddressController {
    @Autowired
    private UserAddressService service;
    Page<UserAdrdess> UserAddressPage;
    @GetMapping
    private ResponseEntity<List<UserAdrdess>> getAll(@RequestParam(defaultValue = "1")int page){
        if(page<1) page=1;
        int pageNum = page-1;
        int pageSize=5;
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        UserAddressPage = service.getAll(pageable);
        return ResponseEntity.ok(UserAddressPage.getContent());
    }

    @PostMapping
    private ResponseEntity<UserAdrdess> add(@RequestBody UserAdrdess userAdrdess){
        service.add(userAdrdess);
        return ResponseEntity.ok(userAdrdess);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable("id")Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
