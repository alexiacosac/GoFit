package com.gofit.repository;

import com.gofit.model.Meal;
import com.gofit.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByTargetGoal(Goal goal);
}