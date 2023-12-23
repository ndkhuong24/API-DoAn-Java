package com.example.demo.repository;

import com.example.demo.model.Product3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProduct2Respository extends JpaRepository<Product3,Integer> {
    @Query(value = "SELECT p.id,  p.name AS product_name,(\n" +
            "        SELECT STRING_AGG(c.name, ', ')\n" +
            "        FROM ProductDetail AS pd\n" +
            "        JOIN Color AS c ON pd.color_id = c.id\n" +
            "        WHERE pd.product_id = p.id\n" +
            "    ) AS colors,\n" +
            "\t(\n" +
            "        SELECT STRING_AGG(b.name, ', ')\n" +
            "        FROM ProductDetail AS pd\n" +
            "        JOIN Brand AS b ON pd.brand_id = b.id\n" +
            "        WHERE pd.product_id = p.id\n" +
            "    ) AS brands,\n" +
            "\t(\n" +
            "        SELECT STRING_AGG(c.name, ', ')\n" +
            "        FROM ProductDetail AS pd\n" +
            "        JOIN Category AS c ON pd.category_id = c.id\n" +
            "        WHERE pd.product_id = p.id\n" +
            "    ) AS categorys,\n" +
            "\t(\n" +
            "        SELECT STRING_AGG(c.name, ', ')\n" +
            "        FROM ProductDetail AS pd\n" +
            "        JOIN Size AS c ON pd.size_id = c.id\n" +
            "        WHERE pd.product_id = p.id\n" +
            "    ) AS sizes,\n" +
            "\t(\n" +
            "        SELECT STRING_AGG(c.name, ', ')\n" +
            "        FROM ProductDetail AS pd\n" +
            "        JOIN Sole AS c ON pd.sole_id = c.id\n" +
            "        WHERE pd.product_id = p.id\n" +
            "    ) AS soles,\n" +
            "\t(\n" +
            "        SELECT STRING_AGG(c.name, ', ')\n" +
            "        FROM ProductDetail AS pd\n" +
            "        JOIN Material AS c ON pd.material_id = c.id\n" +
            "        WHERE pd.product_id = p.id\n" +
            "    ) AS materials\n" +
            "FROM Product AS p ",nativeQuery = true)
    List<Object[]> getAll();
}
