package kr.ac.jejunu.cafeteria.review.suyeon.repository;

import kr.ac.jejunu.cafeteria.review.suyeon.model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuModel, Integer> {
}
