package com.example.demo.repository;

import com.example.demo.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMaterialRepository extends JpaRepository<Material, Integer> {
    @Query(value = "SELECT * FROM Material WHERE name LIKE %?1%", nativeQuery = true)
    List<Material> findByName(String name);

    @Query(value = "SELECT * FROM Material WHERE [status]=1", nativeQuery = true)
    List<Material> getAllMaterialActive();

    @Query(value = "select Material.id,Material.name,Material.status from Material join ProductDetail on ProductDetail.material_id =Material.id \n" +
            "join Product on Product.id = ProductDetail.product_id \n" +
            "where Product.id=?1 and ProductDetail.status=1;",nativeQuery = true)
    List<Material> finbyProduct(Integer id);
}
