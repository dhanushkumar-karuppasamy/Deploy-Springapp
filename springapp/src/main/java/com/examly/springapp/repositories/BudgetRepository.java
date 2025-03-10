package com.examly.springapp.repositories;

import com.examly.springapp.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    @Query("SELECT b FROM Budget b WHERE b.category = :category")
    List<Budget> findBudgetsByCategory(String category);

    List<Budget> findByUserIdAndCategory(Long userId, String category);
}
