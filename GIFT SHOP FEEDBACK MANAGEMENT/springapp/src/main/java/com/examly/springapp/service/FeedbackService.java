package com.examly.springapp.service;

import com.examly.springapp.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);
    List<Feedback> getAllFeedback();
    Feedback getFeedback(long id);
    Feedback updateFeedback(long id, Feedback feedback);
    void deleteFeedback(long id);
    
    Page<Feedback> getAllFeedbackPaginated(Pageable pageable);
}