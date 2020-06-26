package kr.ac.jejunu.cafeteria.review.suyeon.service.impl;

import kr.ac.jejunu.cafeteria.review.suyeon.model.ReviewModel;
import kr.ac.jejunu.cafeteria.review.suyeon.repository.ReviewRepository;
import kr.ac.jejunu.cafeteria.review.suyeon.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        reviewModel.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        reviewModel.setStar(reviewModel.getStar());
        reviewModel.setPassword(reviewModel.getPassword());
        reviewRepository.save(reviewModel);
    }

    @Override
    public boolean update(ReviewModel reviewModel){
        if(findByPassword(reviewModel.getId()).equals(reviewModel.getPassword())) {
            ReviewModel review = reviewRepository.getOne(reviewModel.getId());
            reviewModel.setSection(reviewModel.getSection());
            review.setTitle(reviewModel.getTitle());
            review.setContent(reviewModel.getContent());
            reviewModel.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            review.setStar(reviewModel.getStar());
            reviewRepository.save(review);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(ReviewModel reviewModel){
        if(findByPassword(reviewModel.getId()).equals(reviewModel.getPassword())){
            ReviewModel review = reviewRepository.getOne(reviewModel.getId());
            reviewRepository.delete(review);
            return true;
        }else{
            return false;
        }
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

    @Override
    public List<ReviewModel> findBySection(String section){ return reviewRepository.findBySection(section);  }
}
