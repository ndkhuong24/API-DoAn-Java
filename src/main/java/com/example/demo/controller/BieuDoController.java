package com.example.demo.controller;

import com.example.demo.model.Bieudo;
import com.example.demo.service.BieuDo.BieuDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BieuDoController {
    @Autowired
    private BieuDoService service;

    @GetMapping("/bieudo/{month}")
    public ResponseEntity<List<Bieudo>>getMouthAndPrice(@PathVariable Integer month){

        return ResponseEntity.ok(service.getMouthAndPrice(month));
    }
}
