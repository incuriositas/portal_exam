package kr.ac.jejunu.cafeteria.review.suyeon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ReviewController {

    @GetMapping("")
    public String index(){
        return "index";
    }

    @RequestMapping("/{section}")
    public String show(@PathVariable String section, Model model){
        String res = section;
        model.addAttribute("section",res);
        return "show";
    }

}
