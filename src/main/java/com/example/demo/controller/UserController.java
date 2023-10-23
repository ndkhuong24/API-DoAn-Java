package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/User")
public class UserController {
    @Autowired
    private UserService userService;
    Page<Users> userPage;


    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasAnyRole('MANAGER')")
    public ResponseEntity<List<Users>> getAllPage(@RequestParam(defaultValue = "1") int page, HttpServletRequest request) {

                if (page < 1) page = 1;
                int pageNumber = page - 1;
                int pageSize = 5;
                Pageable pageable = PageRequest.of(pageNumber, pageSize);
                userPage = userService.getAllPage(pageable);
                return ResponseEntity.ok(userPage.getContent());

    }

    @PostMapping
    public ResponseEntity<Users> postUsers(@RequestBody Users user) {
        userService.add(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<Users> putUsers(@RequestBody Users user) {
        userService.update(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsers(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

}
