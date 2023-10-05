package com.example.demo.repository;

import com.example.demo.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
    @Query(value = "EXEC GetProductDetail",nativeQuery = true)
    List<ProductDetail> getAll();

    @Query(value = "EXEC GetProductDetail @Id=:id",nativeQuery = true)
    ProductDetail getById(@Param("id") Integer id);
}
