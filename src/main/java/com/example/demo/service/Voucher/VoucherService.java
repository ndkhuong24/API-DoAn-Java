package com.example.demo.service.Voucher;

import com.example.demo.model.Voucher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VoucherService {
    Page<Voucher> getAllPage(Pageable pageable);
    void add(Voucher voucher);
    void update(Voucher voucher);
    void delete(Integer id);
    Voucher getById(Integer id);
}
