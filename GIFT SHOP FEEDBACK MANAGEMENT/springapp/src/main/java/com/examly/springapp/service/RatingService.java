package com.examly.springapp.service;

import com.examly.springapp.model.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface RatingService {
    Rating saveRating(Rating rating);
    List<Rating> getAllRating();
    Page<Rating> getAllRatingPaginated(Pageable pageable);
    Rating getRating(long id);
    Rating updateRating(long id, Rating rating);
    void deleteRating(long id);
}