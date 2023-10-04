package com.example.demo.repository;

import com.example.demo.modelDTO.ProductDetailAnhImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDetailAnhImageRepositiry extends JpaRepository<ProductDetailAnhImage, Integer> {

    void add(ProductDetailAnhImage productDetailAnhImage);
}
