package kr.ac.jejunu.cafeteria.review.suyeon.service.impl;

import kr.ac.jejunu.cafeteria.review.suyeon.model.ReviewModel;
import kr.ac.jejunu.cafeteria.review.suyeon.repository.ReviewRepository;
import kr.ac.jejunu.cafeteria.review.suyeon.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        reviewModel.setStar(reviewModel.getStar());
        reviewModel.setPassword(reviewModel.getPassword());
        reviewRepository.save(reviewModel);
    }

    @Override
    public void update(ReviewModel reviewModel){
        ReviewModel review = reviewRepository.getOne(reviewModel.getId());
        review.setTitle(reviewModel.getTitle());
        review.setContent(reviewModel.getContent());
        reviewModel.setDate(LocalDateTime.now());
        review.setStar(reviewModel.getStar());
        reviewRepository.save(review);
    }

    @Override
    public void deleteById(int id){
        reviewRepository.deleteById(id);
    }


    @Override
    public List<ReviewModel> findAll(){
        return reviewRepository.findAll();
    }

    @Override
    public Optional<ReviewModel> findById(int id){
        return reviewRepository.findById(id);
    }

    @Override
    public List<Integer> findByStar(String section){
        return reviewRepository.findByStar(section);
    }

    @Override
    public String findByPassword(int id){
        return reviewRepository.findByPassword(id);
    }
}
