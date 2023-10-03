package com.example.demo.service.CartDetail;

import com.example.demo.model.CartDetail;
import com.example.demo.repository.ICartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CartDetailServiceImpl implements CartDetailService {
    @Autowired
    private ICartDetailRepository repository;

    @Override
    public Page<CartDetail> getALL(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(CartDetail cartDetail) {
        repository.save(cartDetail);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
