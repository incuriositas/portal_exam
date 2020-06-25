package kr.ac.jejunu.cafeteria.review.suyeon.service;

import kr.ac.jejunu.cafeteria.review.suyeon.model.MenuModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    void create(MenuModel menuModel);

    List<MenuModel> findAll();
    List<MenuModel> findByDay(String day);
    List<MenuModel> findByDivision(String division);
}
