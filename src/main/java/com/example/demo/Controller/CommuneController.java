package com.example.demo.Controller;


import com.example.demo.Model.Commune;
import com.example.demo.Repository.CommuneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/commune")
public class CommuneController {
    @Autowired
    private CommuneRepository repository;

    @GetMapping
    public ResponseEntity<List<Commune>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }
    @PostMapping
    public ResponseEntity<List<Commune>> add(@RequestBody List<Commune>list){
        repository.saveAll(list);
        return ResponseEntity.ok(list);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
