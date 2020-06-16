package kr.ac.jejunu.cafeteria.review.suyeon.repository;

import kr.ac.jejunu.cafeteria.review.suyeon.model.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, Integer> {
}
