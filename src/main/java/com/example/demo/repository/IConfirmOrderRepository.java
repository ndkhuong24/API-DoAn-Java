package com.example.demo.repository;

import com.example.demo.model.ConfirmOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConfirmOrderRepository extends JpaRepository<ConfirmOrders,Integer> {
}
