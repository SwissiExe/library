package com.bbw.library.controller;

import com.bbw.library.model.Review;
import com.bbw.library.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/get/reviews")
    public List<Review> getAllReviews() {
        return this.reviewService.getAllReviews();
    }

    @GetMapping("/get/reviews/book/{bookId}")
    public List<Review> getReviewsByBookId(@PathVariable Long bookId) {
        return this.reviewService.getReviewsByBookId(bookId);
    }

    @PostMapping("/add/review/{bookId}")
    public Review addReview(@RequestBody Review review, @PathVariable Long bookId) {
        return this.reviewService.addReview(review, bookId);
    }

    @PutMapping("/update/review/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
        return this.reviewService.updateReview(id, review);
    }

    @DeleteMapping("/delete/review/{id}")
    public void deleteReview(@PathVariable Long id) {
        this.reviewService.deleteReview(id);
    }
}
