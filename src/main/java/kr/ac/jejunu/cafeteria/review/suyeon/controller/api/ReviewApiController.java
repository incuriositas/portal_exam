package kr.ac.jejunu.cafeteria.review.suyeon.controller.api;

import kr.ac.jejunu.cafeteria.review.suyeon.model.ReviewModel;
import kr.ac.jejunu.cafeteria.review.suyeon.repository.ReviewRepository;
import kr.ac.jejunu.cafeteria.review.suyeon.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewApiController {
    private final ReviewService reviewService;

    @PostMapping("")
    public void post(@RequestBody ReviewModel reviewModel){
        reviewService.create(reviewModel);
    }

    @GetMapping("")
    public List<ReviewModel> show(){
        return reviewService.findAll();
    }

    @GetMapping("/edit/{id}")
    public Optional<ReviewModel> get(@PathVariable("id") Integer id){
        return reviewService.findById(id);
    }

    @PostMapping("/edit")
    public ResponseEntity<Boolean> update(@RequestBody ReviewModel reviewModel){
        return new ResponseEntity<>(reviewService.update(reviewModel),HttpStatus.OK);
    }

    @PostMapping("/del")
    public ResponseEntity<Boolean> delete(@RequestBody ReviewModel reviewModel) {
        return new ResponseEntity<>( reviewService.delete(reviewModel) ,HttpStatus.OK );
    }

    @GetMapping("/star/{section}")
    public List<Integer> section(@PathVariable String section){
        return reviewService.findByStar(section);
    }

    @GetMapping("/{section}")
    public List<ReviewModel> review(@PathVariable("section") String section){ return reviewService.findBySection(section);}
}
