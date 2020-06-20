package kr.ac.jejunu.cafeteria.review.suyeon.service;

import kr.ac.jejunu.cafeteria.review.suyeon.model.ReviewModel;
import kr.ac.jejunu.cafeteria.review.suyeon.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    void create(ReviewModel reviewModel);
    void update(ReviewModel reviewModel);
}
