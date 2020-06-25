package kr.ac.jejunu.cafeteria.review.suyeon.repository;

import kr.ac.jejunu.cafeteria.review.suyeon.model.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, Integer> {
    @Query(value = "select star from review where section=?1", nativeQuery = true)
    List<Integer> findByStar(String section);

    @Query(value = "select password from review where id=?1", nativeQuery = true)
    String findByPassword(Integer id);
}
