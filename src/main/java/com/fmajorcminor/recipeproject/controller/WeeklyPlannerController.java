package com.fmajorcminor.recipeproject.controller;

import com.fmajorcminor.recipeproject.model.Recipe;
import com.fmajorcminor.recipeproject.model.WeeklyPlanner;
import com.fmajorcminor.recipeproject.repository.RecipeRepository;
import com.fmajorcminor.recipeproject.repository.WeeklyPlannerRepository;
import com.fmajorcminor.recipeproject.service.WeeklyPlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/weekly-planner")
public class WeeklyPlannerController {
    private final static Logger logger = Logger.getLogger(WeeklyPlannerController.class.getName());

    @Autowired
    private WeeklyPlannerRepository weeklyPlannerRepository;

    @Autowired
    private WeeklyPlannerService weeklyPlannerService;

    private RecipeRepository recipeRepository;

    @GetMapping
    public List<WeeklyPlanner> getAllWeeks() {
        logger.log(Level.INFO, "Get all weeks API called");
        return weeklyPlannerService.getAllWeeks();
    }

    @GetMapping("{weekId}")
    public WeeklyPlanner getWeeklyPlanner(@PathVariable("weekId") Long weekId) {
        return weeklyPlannerService.getWeeklyPlanner(weekId);
    }

    @GetMapping("{weekId}/recipes")
    public Set<Recipe> getRecipesForSpecificWeek(@PathVariable("weekId") Long weekId) {
        return weeklyPlannerService.getRecipeForWeek(weekId);
    }

    @PutMapping("{weekId}/recipes/{recipeId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String addRecipe(@PathVariable("weekId") Long weekId, @PathVariable("recipeId") Long recipeId) {
        return weeklyPlannerService.saveRecipe(weekId, recipeId);

    }

}
