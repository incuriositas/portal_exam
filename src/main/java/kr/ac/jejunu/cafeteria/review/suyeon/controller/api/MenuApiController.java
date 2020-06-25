package kr.ac.jejunu.cafeteria.review.suyeon.controller.api;

import kr.ac.jejunu.cafeteria.review.suyeon.model.MenuModel;
import kr.ac.jejunu.cafeteria.review.suyeon.service.MenuService;
import kr.ac.jejunu.cafeteria.review.suyeon.service.GetMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuApiController {
    private final MenuService menuService;
    private final GetMenuService getMeMuService;

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
        return menuService.findAll();
    }

    @GetMapping("/{day}")
    public List<MenuModel> section(@PathVariable("day") String day){
        return menuService.findByDay(day);
    }

    @GetMapping("/list/{division}")
    public List<MenuModel> division(@PathVariable("division") String division){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("regular_meal", "정식");
        map.put("special_meal", "특식");
        map.put("western_meal", "양식");
        map.put("chinese_meal", "중식");
        map.put("regular_meal_dinner", "정식");
        return menuService.findByDivision(map.get(division));
    }

}
