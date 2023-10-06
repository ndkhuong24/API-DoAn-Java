package com.example.demo.service.Orders;

import com.example.demo.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrdersService {
    void add(Orders orders);
    void delete(Integer id);

    Page<Orders> getAll(Pageable pageable);
}
