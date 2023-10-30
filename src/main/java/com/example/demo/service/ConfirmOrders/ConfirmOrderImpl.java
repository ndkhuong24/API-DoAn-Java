package com.example.demo.service.ConfirmOrders;

import com.example.demo.model.ConfirmOrders;
import com.example.demo.model.Orders;
import com.example.demo.repository.IConfirmOrderRepository;
import com.example.demo.repository.IOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfirmOrderImpl implements ConfirmOrderService{
    @Autowired
    IConfirmOrderRepository confirmOrderRepository;
    @Autowired
    IOrdersRepository ordersRepository;

    public ConfirmOrders confirm(ConfirmOrders confirmOrders){
        List<Orders> orders=ordersRepository.findAll();
        for (Orders item :orders) {
            if (item.getStatus()==0) {
                confirmOrders.setStatus(1);
                confirmOrderRepository.save(confirmOrders);
                item.setStatus(confirmOrders.getStatus());
                ordersRepository.save(item);
            }

        }
        return confirmOrders;
    }
}
