package com.example.demo.controller;

import com.example.demo.model.Review;
import com.example.demo.service.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Review")
public class ReviewController {
    @Autowired
    private ReviewService service;
    Page<Review> reviewPage;
    @GetMapping
    public ResponseEntity<List<Review>> getAllPage(@RequestParam(defaultValue = "1")int page){
        if (page < 1) page = 1;
        int pageNumber = page - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        reviewPage = service.getAllPage(pageable);
        return ResponseEntity.ok(reviewPage.getContent());
    }
    @PostMapping
    public ResponseEntity<Review> postReview(@RequestBody Review review){
        service.add(review);
        return ResponseEntity.ok(review);
    }
    @PutMapping
    public ResponseEntity<Review> putReview(@RequestBody Review review){
        service.update(review);
        return ResponseEntity.ok(review);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
