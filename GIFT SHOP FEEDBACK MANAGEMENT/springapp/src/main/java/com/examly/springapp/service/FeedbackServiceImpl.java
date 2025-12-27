package com.examly.springapp.service;

import com.examly.springapp.model.Feedback;
import com.examly.springapp.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepo feedbackRepo;

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepo.findAll();  
    }

    @Override
    public Page<Feedback> getAllFeedbackPaginated(Pageable pageable) {
        return feedbackRepo.findAll(pageable);  
    }

    @Override
    public Feedback getFeedback(long id) {
        return feedbackRepo.findById(id).orElse(null);
    }

    @Override
    public Feedback updateFeedback(long id, Feedback feedback) {
        if (feedbackRepo.existsById(id)) {
            feedback.setFeedbackId(id);
            return feedbackRepo.save(feedback);
        }
        return null;
    }

    @Override
    public void deleteFeedback(long id) {
        feedbackRepo.deleteById(id);
    }
}