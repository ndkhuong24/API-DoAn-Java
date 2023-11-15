package com.example.demo.repository;

import com.example.demo.model.Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFilterRespository extends JpaRepository<Filter,Integer> {
    @Query(value = "SELECT \n" +
            "\tPD.id AS id, IC.path AS path, P.name AS product_name, C.name AS category_name, B.name AS brand_name, S.name AS size_name, Cl.name AS color_name, Sol.name AS sole_name, M.name AS material_name,PD.price AS price\n" +
            "\tFROM \n" +
            "\t\tProductDetail AS PD\n" +
            "\t\tJOIN Product AS P ON PD.product_id = P.id \n" +
            "\t\tJOIN Category AS C ON C.id = PD.category_id\n" +
            "\t\tJOIN Brand AS B ON B.id = PD.brand_id\n" +
            "\t\tJOIN Size AS S ON S.id = PD.size_id\n" +
            "\t\tJOIN Color AS Cl ON Cl.id = PD.color_id\n" +
            "\t\tJOIN Sole AS Sol ON Sol.id = PD.sole_id\n" +
            "\t\tJOIN Material AS M ON M.id = PD.material_id\n" +
            "\t\tJOIN ImageChinh AS IC ON PD.id = IC.product_detail_id", nativeQuery = true)
    List<Filter> filter();
}


