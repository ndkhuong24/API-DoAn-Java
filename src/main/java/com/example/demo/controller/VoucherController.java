package com.example.demo.controller;

import com.example.demo.model.Voucher;
import com.example.demo.service.Voucher.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Voucher")
public class VoucherController {
    @Autowired
    private VoucherService service;
    Page<Voucher> voucherPage;

    @GetMapping("/{name}")
    public ResponseEntity<List<Voucher>> searchVoucher(@PathVariable String name) {
        List<Voucher> voucher = service.findByName(name);
        return ResponseEntity.ok(voucher);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Voucher>> getAllVoucher() {
        return ResponseEntity.ok(service.getAll());
    }

//    @GetMapping("/getAll/active")
//    public ResponseEntity<List<Voucher>> getAllVoucherActive() {
//        return ResponseEntity.ok(service.getAllVoucherActive());
//    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Voucher> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Voucher>> getAllPage(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        voucherPage = service.getAllPage(pageable);
        return ResponseEntity.ok(voucherPage.getContent());
    }

    @PostMapping
    public ResponseEntity<Voucher> postVoucher(@RequestBody Voucher voucher) {
        service.add(voucher);
        return ResponseEntity.ok(voucher);
    }

    @PutMapping
    public ResponseEntity<Voucher> putVoucher(@RequestBody Voucher voucher) {
        service.update(voucher);
        return ResponseEntity.ok(voucher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVoucher(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
