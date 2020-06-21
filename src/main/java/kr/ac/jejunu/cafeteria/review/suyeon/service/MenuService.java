package kr.ac.jejunu.cafeteria.review.suyeon.service;

import kr.ac.jejunu.cafeteria.review.suyeon.model.MenuModel;
import org.springframework.stereotype.Service;

@Service
public interface MenuService {
    void create(MenuModel menuModel);
}
