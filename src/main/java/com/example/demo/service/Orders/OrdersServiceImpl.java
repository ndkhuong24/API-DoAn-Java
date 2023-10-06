package com.example.demo.service.Orders;

import com.example.demo.model.Orders;
import com.example.demo.repository.IOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private IOrdersRepository repository;

    @Override
    public void add(Orders orders) {
        repository.save(orders);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Orders> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
