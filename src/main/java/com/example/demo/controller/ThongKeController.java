package com.example.demo.controller;

import com.example.demo.model.Thongke;
import com.example.demo.repository.IThongkeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ThongKeController {
    @Autowired
    private IThongkeRepository repository;

    @RequestMapping("/thongke/month")
    public ResponseEntity<List<Thongke>> getpricemonth(){
        return ResponseEntity.ok(repository.getpricebymonth());
    }

    @RequestMapping("/thongke/year")
    public ResponseEntity<List<Thongke>> getpriceyear(){
        return ResponseEntity.ok(repository.getpricebyyear());
    }
}
