package kr.ac.jejunu.cafeteria.review.suyeon.service;

import kr.ac.jejunu.cafeteria.review.suyeon.model.ReviewModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReviewService {
    void create(ReviewModel reviewModel);
    void update(ReviewModel reviewModel);
    void deleteById(int id);

    List<ReviewModel> findAll();
    Optional<ReviewModel> findById(int id);
    List<Integer> findByStar(String section);
    String findByPassword(int id);
}
