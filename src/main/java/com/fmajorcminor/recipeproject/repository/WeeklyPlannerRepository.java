package com.fmajorcminor.recipeproject.repository;

import com.fmajorcminor.recipeproject.model.WeeklyPlanner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeeklyPlannerRepository extends JpaRepository<WeeklyPlanner, Long> {

}
