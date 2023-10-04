package com.example.demo.service.Order;

import com.example.demo.model.Order;
import com.example.demo.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private IOrderRepository repository;

    @Override
    public void add(Order order) {
        repository.save(order);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Order> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
