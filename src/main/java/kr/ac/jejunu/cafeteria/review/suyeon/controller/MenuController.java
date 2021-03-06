package kr.ac.jejunu.cafeteria.review.suyeon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/list")
public class MenuController {

    @RequestMapping("/{division}")
    public String menu(@PathVariable String division){
        return "menu";
    }
}
