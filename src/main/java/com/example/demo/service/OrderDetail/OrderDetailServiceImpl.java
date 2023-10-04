package com.example.demo.service.OrderDetail;

import com.example.demo.model.OrderDetail;
import com.example.demo.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    private IOrderDetailRepository repository;

    @Override
    public Page<OrderDetail> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(OrderDetail orderDetail) {
        repository.save(orderDetail);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
