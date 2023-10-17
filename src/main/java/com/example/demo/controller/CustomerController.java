package com.example.demo.controller;

import com.example.demo.JwtAuthencationFilter;
import com.example.demo.JwtUtils;
import com.example.demo.model.Customer;
import com.example.demo.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    Page<Customer> CustomerPage;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private JwtAuthencationFilter jwtAuthencationFilter;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllPage(@RequestParam(defaultValue = "1") int page, HttpServletRequest request) {
        String token=jwtAuthencationFilter.extractTokenFromRequest(request);
        if(token!=null){
            String username=jwtUtils.extractUserName(token);
            if(username!=null){
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        CustomerPage = customerService.getAllPage(pageable);
        return ResponseEntity.ok(CustomerPage.getContent());
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer Customer) {
        customerService.add(Customer);
        return ResponseEntity.ok(Customer);
    }

    @PutMapping
    public ResponseEntity<Customer> putCustomer(@RequestBody Customer Customer) {
        customerService.update(Customer);
        return ResponseEntity.ok(Customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
