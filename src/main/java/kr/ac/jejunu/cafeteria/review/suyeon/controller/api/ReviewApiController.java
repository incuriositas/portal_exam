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

    @PutMapping("")
    public void update(@RequestBody ReviewModel reviewModel){
        reviewService.update(reviewModel);
    }

    @GetMapping("/del/{id}")
    public void delete(@PathVariable("id") Integer id){
        reviewService.deleteById(id);
    }

    @GetMapping("/star/{section}")
    public List<Integer> section(@PathVariable String section){
        return reviewService.findByStar(section);
    }

    @PostMapping("/{id}/password")
    public String check(@PathVariable("id") Integer id){return reviewService.findByPassword(id);}

    @GetMapping("/{section}")
    public List<ReviewModel> review(@PathVariable("section") String section){ return reviewService.findBySection(section);}
}
