package com.example.demo.service.Product;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<ProductDTO> getAll(Pageable pageable) {
        Page<Product>products=productRepository.findAll(pageable);
       return products.map(this::convertProductDTO);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductDTO convertProductDTO(Product product){
        ProductDTO productDTO=new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setCode(product.getCode());
        productDTO.setDescription(product.getDescription());
        productDTO.setName(product.getName());
        productDTO.setStatus(product.getStatus());
        productDTO.setCreateDate(product.getCreateDate());
        productDTO.setStyle_id(product.getStyle_id().getName());
        productDTO.setBrand_id(product.getBrand_id().getName());
        productDTO.setCategory_id(product.getCategory_id().getName());
        return productDTO;
    }
    public ProductDTO   Add(Product product){
        Product product1=productRepository.save(product);
        return convertProductDTO(product1);
    }
    public ProductDTO   Put(Product product){
        Product product1=productRepository.save(product);
        return convertProductDTO(product1);
    }
}
