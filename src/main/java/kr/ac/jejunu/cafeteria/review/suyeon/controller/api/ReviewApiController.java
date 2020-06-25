package kr.ac.jejunu.cafeteria.review.suyeon.controller.api;

import kr.ac.jejunu.cafeteria.review.suyeon.model.ReviewModel;
import kr.ac.jejunu.cafeteria.review.suyeon.repository.ReviewRepository;
import kr.ac.jejunu.cafeteria.review.suyeon.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        reviewService.update(reviewModel);
    }

    @GetMapping("/del/{id}")
    public void del(@PathVariable("id") Integer id){
        reviewRepository.deleteById(id);
    }

    @GetMapping("/{section}")
    public List<Integer> section(@PathVariable String section){
        return reviewRepository.findBySection(section);
    }

    @PostMapping("/{id}/password")
    public String check(@PathVariable("id") Integer id){return reviewRepository.findByPassword(id);}
}
