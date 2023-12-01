package com.example.demo.repository;

import com.example.demo.model.Thongke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IThongkeRepository extends JpaRepository<Thongke,Integer> {
    @Query(value = "SELECT SUM(final_price) AS sum\n" +
            "FROM Orders\n" +
            "WHERE MONTH(date_create) = MONTH(GETDATE()) AND YEAR(date_create) = YEAR(GETDATE())",nativeQuery = true)
    List<Thongke> getpricebymonth();

    @Query(value = "SELECT SUM(final_price) AS sum\n" +
            "FROM Orders\n" +
            "WHERE  YEAR(date_create) = YEAR(GETDATE());",nativeQuery = true)
    List<Thongke> getpricebyyear();
}
