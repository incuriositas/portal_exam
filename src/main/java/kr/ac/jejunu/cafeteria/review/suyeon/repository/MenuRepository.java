package kr.ac.jejunu.cafeteria.review.suyeon.repository;

import kr.ac.jejunu.cafeteria.review.suyeon.model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuModel, Integer> {
    List<MenuModel> findByDay(String day);
    List<MenuModel> findByDivision(String division);
}
