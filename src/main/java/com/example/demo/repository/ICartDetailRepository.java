package com.example.demo.repository;

import com.example.demo.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICartDetailRepository extends JpaRepository<CartDetail,Integer> {
    @Query("SELECT c FROM CartDetail c WHERE c.user_id = :userId")
    List<CartDetail> getCartDetailByUser_id(@Param("userId") Integer userId);
}
