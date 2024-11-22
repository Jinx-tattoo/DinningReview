package com.dining.review.api.repository;

import java.util.List;

import com.dining.review.api.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByStatus(Review.StatusReview status);
    List<Review> findByIdRestaurant(Long id);
    List<Review> findByIdRestaurantAndStatus(Long id, Review.StatusReview status);
}
