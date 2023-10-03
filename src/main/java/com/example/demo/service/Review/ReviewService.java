package com.example.demo.service.Review;

import com.example.demo.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {
    Page<Review> getAllPage(Pageable pageable);
    void add(Review review);
    void update(Review review);
    void delete(Integer id);
    Review getById(Integer id);
}
