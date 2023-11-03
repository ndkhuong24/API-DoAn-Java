package com.example.demo.repository;

import com.example.demo.model.ImageChinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends JpaRepository<ImageChinh, Integer> {
    @Query(value = "select * from ImageChinh where product_detail_id=?1",nativeQuery = true)
    ImageChinh findbyProduct_detail_id(Integer id);
}
