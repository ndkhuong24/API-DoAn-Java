package com.example.demo.service.Review;

import com.example.demo.model.Review;
import com.example.demo.repository.IReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private IReviewRepository repository;

    @Override
    public Page<Review> getAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(Review review) {
        repository.save(review);
    }

    @Override
    public void update(Review review) {
        repository.save(review);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Review getById(Integer id) {
        return repository.getOne(id);
    }
}
