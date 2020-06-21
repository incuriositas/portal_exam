package kr.ac.jejunu.cafeteria.review.suyeon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menuList")
public class MenuContoller {

    @GetMapping("")
    public String menu(){
        return "menu";
    }
}
