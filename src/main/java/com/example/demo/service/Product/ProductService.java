package com.example.demo.service.Product;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Page<ProductDTO> getAll(Pageable pageable);
    Product findById(Integer id);
    ProductDTO Add(Product product);
    ProductDTO Put(Product product);
}
