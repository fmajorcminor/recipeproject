package com.fmajorcminor.recipeproject.controller;

import com.fmajorcminor.recipeproject.model.Recipe;
import com.fmajorcminor.recipeproject.model.WeeklyPlanner;
import com.fmajorcminor.recipeproject.service.WeeklyPlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/weekly-planner")
public class WeeklyPlannerController {
    private final static Logger logger = Logger.getLogger(WeeklyPlannerController.class.getName());

    @Autowired
    private WeeklyPlannerService weeklyPlannerService;

    @GetMapping
    public List<WeeklyPlanner> getAllWeeks() {
        logger.log(Level.INFO, "Get all weeks API called");
        return weeklyPlannerService.getAllWeeks();
    }

    @GetMapping("{weekId}")
    public WeeklyPlanner getWeeklyPlanner(@PathVariable("weekId") Long weekId) {
        logger.log(Level.INFO, "Get weekly planner API called");
        return weeklyPlannerService.getWeeklyPlanner(weekId);
    }

    @GetMapping("{weekId}/recipes")
    public Set<Recipe> getRecipesForSpecificWeek(@PathVariable("weekId") Long weekId) {
        logger.log(Level.INFO, "Get recipe for specific week API called");
        return weeklyPlannerService.getRecipeForWeek(weekId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WeeklyPlanner create(@RequestBody final WeeklyPlanner weeklyPlanner) {
        logger.log(Level.INFO, "Create weekly planner API called");
        return weeklyPlannerService.saveWeeklyPlanner(weeklyPlanner);
    }

    @PutMapping("{weekId}")
    public WeeklyPlanner update(@PathVariable("weekId") Long weekId, @RequestBody WeeklyPlanner weeklyPlanner) {
        logger.log(Level.INFO, "Update weekly planner API called");
        return weeklyPlannerService.update(weekId, weeklyPlanner);
    }

    @PutMapping("{weekId}/recipes/{recipeId}")
    public String addRecipeToWeek(@PathVariable("weekId") Long weekId, @PathVariable("recipeId") Long recipeId) {
        logger.log(Level.INFO, "Add recipe to week APi called");
        return weeklyPlannerService.saveRecipeForPlanner(weekId, recipeId);
    }

    @DeleteMapping("{weekId}")
    public String deleteWeek(@PathVariable("weekId") Long weekId) {
        logger.log(Level.INFO, "Delete week API called");
        return weeklyPlannerService.deleteWeek(weekId);
    }

}
