package com.example.demo.controller;

import com.example.demo.model.Commune;
import com.example.demo.service.Commune.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commune")
@CrossOrigin("*")
public class CommuneController {
    @Autowired
    private CommuneService service;

    private Page<Commune> PageCommune;

    @GetMapping
    public ResponseEntity<List<Commune>> getAll(@RequestParam (defaultValue = "1")int page){
        if(page<1) page=1;
        int pageNum=page-1;
        int pageSize =5;
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        PageCommune=service.getAll(pageable);
        return ResponseEntity.ok(PageCommune.getContent());
    }
    @PostMapping
    public ResponseEntity<List<Commune>> add(@RequestBody List<Commune> list){
        service.add(list);
        return ResponseEntity.ok(list);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
