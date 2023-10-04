package com.example.demo.service.OrderDetail;

import com.example.demo.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderDetailService {
    Page<OrderDetail> getAll(Pageable pageable);
    void add(OrderDetail orderDetail);
    void delete(Integer id);
}
