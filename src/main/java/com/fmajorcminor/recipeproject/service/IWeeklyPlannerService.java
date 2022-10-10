package com.fmajorcminor.recipeproject.service;

import com.fmajorcminor.recipeproject.model.Recipe;
import com.fmajorcminor.recipeproject.model.WeeklyPlanner;

import java.util.List;
import java.util.Set;

public interface IWeeklyPlannerService {
    String saveRecipeForPlanner(Long weekId, Long recipeId);
    List<WeeklyPlanner> getAllWeeks();
    Set<Recipe> getRecipeForWeek(Long weekId);
    WeeklyPlanner getWeeklyPlanner(Long weekId);
    String deleteWeek(Long weekId);
    WeeklyPlanner saveWeeklyPlanner(WeeklyPlanner weeklyPlanner);
    WeeklyPlanner update(Long id, WeeklyPlanner weeklyPlanner);
}
