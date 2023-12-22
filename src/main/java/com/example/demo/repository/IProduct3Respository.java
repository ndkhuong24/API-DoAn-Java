package com.example.demo.repository;

import com.example.demo.model.Product3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProduct3Respository extends JpaRepository<Product3,Integer> {
    @Query(value = "SELECT p.id ,p.code,p.status, p.name,Brand.name as brand,Category.name as category,Style.name as style, MIN(ProductDetail.price) AS min_price,MAX(ProductDetail.price)as max_price\n" +
            "FROM Product as p\n" +
            "JOIN ProductDetail ON p.id = ProductDetail.product_id\n" +
            "JOIN Brand ON p.brand_id=Brand.id\n" +
            "JOIN Category on p.category_id= Category.id\n" +
            "JOIN Style on p.style_id=Style.id\n" +
            "where ProductDetail.status=1\n" +
            "GROUP BY p.id,p.name,Brand.name,Category.name,Style.name,p.code,p.status",nativeQuery = true)
    List<Product3> getAll();

    @Query(value = "SELECT p.id ,p.code,p.status, p.name,Brand.name as brand,Category.name as category,Style.name as style, MIN(ProductDetail.price) AS min_price,MAX(ProductDetail.price)as max_price\n" +
            "FROM Product as p\n" +
            "JOIN ProductDetail ON p.id = ProductDetail.product_id\n" +
            "JOIN Brand ON p.brand_id=Brand.id\n" +
            "JOIN Category on p.category_id= Category.id\n" +
            "JOIN Style on p.style_id=Style.id\n" +
            "where ProductDetail.status=1 and p.id=?1\n" +
            "GROUP BY p.id,p.name,Brand.name,Category.name,Style.name,p.code,p.status",nativeQuery = true)
    Product3 getById(Integer id);
}
