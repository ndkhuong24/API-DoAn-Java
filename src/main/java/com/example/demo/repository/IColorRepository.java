package com.example.demo.repository;

import com.example.demo.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IColorRepository extends JpaRepository<Color, Integer> {
    @Query(value = "SELECT * FROM Color WHERE name LIKE %?1%", nativeQuery = true)
    List<Color> findByName(String name);

    @Query(value = "SELECT * FROM Color WHERE [status]=1", nativeQuery = true)
    List<Color> getAllColorActive();

    @Query(value = "select Color.id,Color.name,Color.status from Color join ProductDetail on ProductDetail.color_id =Color.id \n" +
            "join Product on Product.id = ProductDetail.product_id \n" +
            "where Product.id=?1 and ProductDetail.status=1;",nativeQuery = true)
    List<Color> findByProduct(Integer id);
}
