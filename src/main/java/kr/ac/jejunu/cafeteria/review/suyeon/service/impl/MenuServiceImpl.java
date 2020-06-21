package kr.ac.jejunu.cafeteria.review.suyeon.service.impl;

import kr.ac.jejunu.cafeteria.review.suyeon.model.MenuModel;
import kr.ac.jejunu.cafeteria.review.suyeon.repository.MenuRepository;
import kr.ac.jejunu.cafeteria.review.suyeon.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;

    @Override
    public void create(MenuModel menuModel) {
        menuModel.setDay(menuModel.getDay());
        menuModel.setWeekend(menuModel.getWeekend());
        menuModel.setDivision(menuModel.getDivision());
        menuModel.setLunch(menuModel.getLunch());
        menuModel.setDinner(menuModel.getDinner());
        menuRepository.save(menuModel);
    }
}


