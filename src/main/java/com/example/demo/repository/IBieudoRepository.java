package com.example.demo.repository;

import com.example.demo.model.Bieudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBieudoRepository extends JpaRepository<Bieudo,Integer> {
    @Query(value = "SELECT MONTH(date_create) AS month_number, SUM(final_price) AS total_final_price\n" +
            "FROM Orders where year(date_create)=year(getdate()) and month(date_create)=?1\n" +
            "GROUP BY MONTH(date_create) ;",nativeQuery = true )
    List<Bieudo> getMouthAndPrice(Integer month);
}
