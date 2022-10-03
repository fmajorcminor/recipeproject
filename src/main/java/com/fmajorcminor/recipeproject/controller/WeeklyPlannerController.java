package com.fmajorcminor.recipeproject.controller;

import com.fmajorcminor.recipeproject.model.Recipe;
import com.fmajorcminor.recipeproject.model.WeeklyPlanner;
import com.fmajorcminor.recipeproject.repository.RecipeRepository;
import com.fmajorcminor.recipeproject.repository.WeeklyPlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/weekly-planner")
public class WeeklyPlannerController {
    private final static Logger logger = Logger.getLogger(WeeklyPlannerController.class.getName());

    @Autowired
    private WeeklyPlannerRepository weeklyPlannerRepository;

    private RecipeRepository recipeRepository;

    @GetMapping
    public List<WeeklyPlanner> getAllWeeks() {
        logger.log(Level.INFO, "Get all weeks API called");
        return weeklyPlannerRepository.findAll();
    }

    @PostMapping("/{id}/recipes")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addRecipe(@PathVariable("id") Long id, @RequestBody Recipe recipeIn) {
        WeeklyPlanner weeklyPlanner = weeklyPlannerRepository.getReferenceById(id);
        weeklyPlanner.getRecipeList().add(recipeIn);
        weeklyPlannerRepository.saveAndFlush(weeklyPlanner);
    }

}
