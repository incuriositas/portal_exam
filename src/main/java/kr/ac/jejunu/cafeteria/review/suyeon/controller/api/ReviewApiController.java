package kr.ac.jejunu.cafeteria.review.suyeon.controller.api;

import kr.ac.jejunu.cafeteria.review.suyeon.model.ReviewModel;
import kr.ac.jejunu.cafeteria.review.suyeon.repository.ReviewRepository;
import kr.ac.jejunu.cafeteria.review.suyeon.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewApiController {
    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;

    @PostMapping("")
    public void post(@RequestBody ReviewModel reviewModel){
        reviewService.create(reviewModel);
    }

    @GetMapping("")
    public List<ReviewModel> show(){
        return reviewRepository.findAll();
    }
}
