package com.example.demo.repository;

import com.example.demo.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISizeRepository extends JpaRepository<Size, Integer> {
    @Query(value = "SELECT * FROM Size WHERE name LIKE %?1%", nativeQuery = true)
    List<Size> findByName(String name);

    @Query(value = "SELECT * FROM Size WHERE [status]=1", nativeQuery = true)
    List<Size> getAllSizeActive();

    @Query(value = "select Size.id,Size.name,Size.status from Size join ProductDetail on ProductDetail.size_id =Size.id \n" +
            "join Product on Product.id = ProductDetail.product_id \n" +
            "where Product.id=?1 and ProductDetail.status=1;\n",nativeQuery = true)
    List<Size> findByProduct(Integer id);
}
