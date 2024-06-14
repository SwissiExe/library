package com.bbw.library.service;

import com.bbw.library.model.Book;
import com.bbw.library.model.Review;
import com.bbw.library.repository.BookRepository;
import com.bbw.library.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
    }

    public List<Review> getAllReviews() {
        return this.reviewRepository.findAll();
    }

    public List<Review> getReviewsByBookId(Long bookId) {
        return this.reviewRepository.findByBookId(bookId);
    }

    public Review addReview(Review review, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));
        review.setBook(book);
        return this.reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review reviewDetails) {
        return this.reviewRepository.findById(id)
                .map(review -> {
                    review.setName(reviewDetails.getName());
                    review.setRating(reviewDetails.getRating());
                    review.setComment(reviewDetails.getComment());
                    review.setBook(reviewDetails.getBook());
                    return this.reviewRepository.save(review);
                }).orElse(null);
    }

    public void deleteReview(Long id) {
        this.reviewRepository.deleteById(id);
    }
}
