package kr.ac.jejunu.cafeteria.review.suyeon.controller.api;

import kr.ac.jejunu.cafeteria.review.suyeon.model.ReviewModel;
import kr.ac.jejunu.cafeteria.review.suyeon.repository.ReviewRepository;
import kr.ac.jejunu.cafeteria.review.suyeon.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/edit/{id}")
    public Optional<ReviewModel> get(@PathVariable("id") Integer id){
        return reviewRepository.findById(id);
    }

    @PutMapping("")
    public void update(@RequestBody ReviewModel reviewModel){
        System.out.println("updateController");
        reviewService.update(reviewModel);
//        return new ResponseEntity<>("수정완료",HttpStatus.OK);
    }

    @GetMapping("/del/{id}")
    public ResponseEntity<String> del(@PathVariable("id") Integer id){
        reviewRepository.deleteById(id);
        return new ResponseEntity<>("삭제되었습니다 >_", HttpStatus.OK);
    }
}
