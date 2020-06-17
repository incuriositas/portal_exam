package kr.ac.jejunu.cafeteria.review.suyeon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ReviewController {
    @GetMapping("")
    public String index(){
        return "index";
    }

    @GetMapping("/{section}")
    public String show(@PathVariable String section){ return "show"; }

    @GetMapping("/{section}/post")
    public String post(@PathVariable String section){ return "post"; }
}
