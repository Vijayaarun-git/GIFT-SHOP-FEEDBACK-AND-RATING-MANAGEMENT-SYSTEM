package com.examly.springapp.service;

import com.examly.springapp.model.Rating;
import com.examly.springapp.repository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepo.findAll();
    }

    @Override
    public Page<Rating> getAllRatingPaginated(Pageable pageable) {
        return ratingRepo.findAll(pageable);
    }

    @Override
    public Rating getRating(long id) {
        return ratingRepo.findById(id).orElse(null);
    }

    @Override
    public Rating updateRating(long id, Rating rating) {
        if (ratingRepo.existsById(id)) {
            rating.setRatingId(id);
            return ratingRepo.save(rating);
        }
        return null;
    }

    @Override
    public void deleteRating(long id) {
        ratingRepo.deleteById(id);
    }
}