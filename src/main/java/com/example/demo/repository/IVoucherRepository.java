package com.example.demo.repository;

import com.example.demo.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVoucherRepository extends JpaRepository<Voucher, Integer> {
    @Query(value = "SELECT * FROM Voucher WHERE name LIKE %?1%", nativeQuery = true)
    List<Voucher> findByName(String name);

    @Query(value = "SELECT  * FROM  Voucher WHERE [status]=1", nativeQuery = true)
    List<Voucher> getAllVoucherActive();
}
