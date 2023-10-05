package com.example.demo.repository;

import com.example.demo.model.ProductCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductCustomRepository extends JpaRepository<ProductCustom, Integer> {
    @Modifying
    @Query(value = "EXEC InsertProductAndImage @CategoryID = :#{#productCustom.category_id},@BrandID = :#{#productCustom.brand_id},@ProductID = :#{#productCustom.product_id},@SizeID = :#{#productCustom.size_id},@ColorID = :#{#productCustom.color_id},@SoleID = :#{#productCustom.sole_id},@MaterialID = :#{#productCustom.material_id},@Quantity = :#{#productCustom.quantity},@Price = :#{#productCustom.price},@ImageName = :#{#productCustom.name},@ImageURL = :#{#productCustom.url},@Status = :#{#productCustom.status}", nativeQuery = true)
    void add(ProductCustom productCustom);
}
