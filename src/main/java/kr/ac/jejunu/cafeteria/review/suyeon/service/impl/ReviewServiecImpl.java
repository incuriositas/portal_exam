package kr.ac.jejunu.cafeteria.review.suyeon.service.impl;

import kr.ac.jejunu.cafeteria.review.suyeon.model.ReviewModel;
import kr.ac.jejunu.cafeteria.review.suyeon.repository.ReviewRepository;
import kr.ac.jejunu.cafeteria.review.suyeon.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewServiecImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    @Override
    public void create(ReviewModel reviewModel){
        reviewModel.setSection(reviewModel.getSection());
        reviewModel.setTitle(reviewModel.getTitle());
        reviewModel.setContent(reviewModel.getContent());
        reviewModel.setDate(LocalDateTime.now());
        reviewRepository.save(reviewModel);
    }
}
