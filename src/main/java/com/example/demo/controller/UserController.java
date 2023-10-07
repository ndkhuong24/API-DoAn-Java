package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/User")
public class UserController {
    @Autowired
    private UserService userService;
    Page<Users> solePage;

    @GetMapping
    public ResponseEntity<List<Users>> getAllPage(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        solePage = userService.getAllPage(pageable);
        return ResponseEntity.ok(solePage.getContent());
    }

    @PostMapping
    public ResponseEntity<Users> postUsers(@RequestBody Users sole) {
        userService.add(sole);
        return ResponseEntity.ok(sole);
    }

    @PutMapping
    public ResponseEntity<Users> putUsers(@RequestBody Users sole) {
        userService.update(sole);
        return ResponseEntity.ok(sole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsers(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{username}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable String username) {
        Users user = userService.getByUsername(username);

        if (user != null) {
            return ResponseEntity.ok(user); // Trả về người dùng nếu tìm thấy
        } else {
            return ResponseEntity.notFound().build(); // Trả về 404 Not Found nếu không tìm thấy
        }
    }
}
