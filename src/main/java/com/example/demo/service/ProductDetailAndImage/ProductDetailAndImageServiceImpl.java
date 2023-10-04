package com.example.demo.service.ProductDetailAndImage;

import com.example.demo.modelDTO.ProductDetailAnhImage;
import com.example.demo.repository.IProductDetailAnhImageRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailAndImageServiceImpl implements ProductDetailAndImageService {
    @Autowired
    private IProductDetailAnhImageRepositiry repositiry;
    @Override
    public void add(ProductDetailAnhImage productDetailAnhImage) {
        repositiry.add(productDetailAnhImage);
    }
}
