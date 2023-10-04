package com.example.demo.service.Order;

import com.example.demo.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    void add(Order order);
    void delete(Integer id);

    Page<Order> getAll(Pageable pageable);
}
