package kr.ac.jejunu.cafeteria.review.suyeon.service;

import kr.ac.jejunu.cafeteria.review.suyeon.model.ReviewModel;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    void create(ReviewModel reviewModel);
    void update(ReviewModel reviewModel);
}
