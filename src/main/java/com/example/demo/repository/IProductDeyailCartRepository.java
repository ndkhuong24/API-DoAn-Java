package com.example.demo.repository;

import com.example.demo.model.ProductDetailCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDeyailCartRepository extends JpaRepository<ProductDetailCart,Integer> {
    @Query(value = "select ProductDetail.id,Product.name,Size.name as size,Color.name as color,\n" +
            "Material.name as material,Sole.name as sole,ProductDetail.price,ProductDetail.quantity\n" +
            "from ProductDetail\n" +
            "join Product on  ProductDetail.product_id=Product.id \n" +
            "join Size on ProductDetail.size_id=Size.id\n" +
            "join Color on ProductDetail.color_id = Color.id\n" +
            "join Material on ProductDetail.material_id= Material.id\n" +
            "join Sole on ProductDetail.sole_id=Sole.id\n" +
            "where ProductDetail.product_id=?1 and Size.name=?2 and\n" +
            "Color.name=?3 and Material.name=?4 and Sole.name=?5",nativeQuery = true)
    ProductDetailCart getOne(Integer product,String size,String color,String material,String sole);
}
