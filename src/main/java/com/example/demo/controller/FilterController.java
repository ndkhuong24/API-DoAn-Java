package com.example.demo.controller;

import com.example.demo.model.Filter;
import com.example.demo.repository.IFilterRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping("/api")
@CrossOrigin("*")
public class FilterController {
    @Autowired
    private IFilterRespository repos;

    @GetMapping("/filter")
    public List<Filter> filterProduct(@RequestParam(required = false) Double minPrice,
                                      @RequestParam(required = false) Double maxPrice,
                                      @RequestParam(required = false) List<String> colors,
                                      @RequestParam(required = false) List<String> brands,
                                      @RequestParam(required = false) List<String> sizes,
                                      @RequestParam(required = false) List<String> soles,
                                      @RequestParam(required = false) List<String> materials,
                                      @RequestParam(required = false) List<String>products) {
        List<Filter> list = repos.filter();

        return list.stream()
                .filter(product -> (minPrice == null || product.getPrice() >= minPrice) &&
                        (maxPrice == null || product.getPrice() <= maxPrice) &&
                        (colors == null || colors.isEmpty() || colors.contains(product.getColorName())) &&
                        (brands == null || brands.isEmpty() || brands.contains(product.getBrandName())) &&
                        (sizes == null || sizes.isEmpty() || sizes.contains(product.getSizeName())) &&
                        (soles == null || soles.isEmpty() || soles.contains(product.getSoleName())) &&
                        (materials == null || materials.isEmpty() || materials.contains(product.getMaterialName()))&&
                        (products==null||products.isEmpty()||isSimilarProductPresent(products, product.getProductName()))
                )
                .collect(Collectors.toList());

    }
    private boolean isSimilarProductPresent(List<String> products, String productName) {
        for (String product : products) {
            // Sử dụng phương thức contains để kiểm tra xem chuỗi brand có tồn tại trong brandName hay không
            if (productName.toLowerCase().contains(product.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List> search(@PathVariable String name ){
        return ResponseEntity.ok(repos.search(name));
    }
}