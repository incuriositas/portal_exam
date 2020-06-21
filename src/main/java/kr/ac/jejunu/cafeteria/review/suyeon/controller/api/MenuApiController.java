package kr.ac.jejunu.cafeteria.review.suyeon.controller.api;

import kr.ac.jejunu.cafeteria.review.suyeon.model.MenuModel;
import kr.ac.jejunu.cafeteria.review.suyeon.repository.MenuRepository;
import kr.ac.jejunu.cafeteria.review.suyeon.service.MenuService;
import kr.ac.jejunu.cafeteria.review.suyeon.service.GetMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuApiController {
    private final MenuService menuService;
    private final GetMenuService getMeMuService;
    private final MenuRepository menuRepository;

    @GetMapping("/data")
    public void create(Model model) throws IOException {
        List<MenuModel> menuList = getMeMuService.getMenu();
        model.addAttribute("menuList",menuList);
        for(int i = 0; i < menuList.size(); i++){
            menuService.create(menuList.get(i));
        }
    }

    @GetMapping("")
    public List<MenuModel> show(){
        return menuRepository.findAll();
    }

    @GetMapping("/{day}")
    public List<MenuModel> section(@PathVariable("day") String day){
        return menuRepository.findByDay(day);
    }
}
