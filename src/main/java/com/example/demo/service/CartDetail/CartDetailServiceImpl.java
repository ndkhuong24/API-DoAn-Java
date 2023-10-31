package com.example.demo.service.CartDetail;

import com.example.demo.model.CartDetail;
import com.example.demo.repository.ICartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartDetailServiceImpl implements CartDetailService {
    @Autowired
    private ICartDetailRepository cartDetailRepository;

    @Override
    public Page<CartDetail> getALL(Pageable pageable) {
        return cartDetailRepository.findAll(pageable);
    }

    @Override
    public CartDetail add(CartDetail cartDetail) {
        List<CartDetail> getByUser=cartDetailRepository.getCartDetailByUser_id(cartDetail.getUser_id());
        for (CartDetail item: getByUser) {
            if(item.getProduct_detail_id()==cartDetail.getProduct_detail_id() && item.getUser_id()==cartDetail.getUser_id()){
                int quatity=item.getQuantity()+cartDetail.getQuantity();
                item.setQuantity(quatity);
                cartDetailRepository.save(item);
                return item;
            }
        }
        cartDetailRepository.save(cartDetail);
        return cartDetail;
    }


    @Override
    public void delete(Integer id) {
        cartDetailRepository.deleteById(id);
    }
}
