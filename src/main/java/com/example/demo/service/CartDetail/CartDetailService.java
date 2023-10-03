package com.example.demo.service.CartDetail;

import com.example.demo.model.CartDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CartDetailService {
    Page<CartDetail> getALL(Pageable pageable);
    void add(CartDetail cartDetail);
    void delete(Integer id);
}
