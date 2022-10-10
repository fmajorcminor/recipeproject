package com.fmajorcminor.recipeproject.service;

import com.fmajorcminor.recipeproject.controller.WeeklyPlannerController;
import com.fmajorcminor.recipeproject.model.Recipe;
import com.fmajorcminor.recipeproject.model.WeeklyPlanner;
import com.fmajorcminor.recipeproject.repository.RecipeRepository;
import com.fmajorcminor.recipeproject.repository.WeeklyPlannerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class WeeklyPlannerService implements IWeeklyPlannerService{

    private final static Logger logger = Logger.getLogger(WeeklyPlannerService.class.getName());


    @Autowired
    private WeeklyPlannerRepository weeklyPlannerRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public String saveRecipeForPlanner(Long weekId, Long recipeId) {
        Recipe recipe = recipeRepository.getReferenceById(recipeId);
        WeeklyPlanner weeklyPlanner = weeklyPlannerRepository.getReferenceById(weekId);


        if (weeklyPlanner.getRecipeList().contains(recipe)) {
            logger.info("Not added. Already part of week");
            return "Recipe not added. It's already part of planned week";
        }
        weeklyPlanner.getRecipeList().add(recipe);
        weeklyPlannerRepository.saveAndFlush(weeklyPlanner);

        logger.info("Added");
        return "Recipe added: " + "\n" + recipe;
    }

    @Override
    public List<WeeklyPlanner> getAllWeeks() {
        return weeklyPlannerRepository.findAll();
    }

    @Override
    public WeeklyPlanner getWeeklyPlanner(Long weekId) {
        return weeklyPlannerRepository.getReferenceById(weekId);
    }

    @Override
    public Set<Recipe> getRecipeForWeek(Long weekId) {
        WeeklyPlanner weeklyPlanner = weeklyPlannerRepository.getReferenceById(weekId);
        return weeklyPlanner.getRecipeList();
    }

    @Override
    public String deleteWeek(Long weekId) {
        String result = "Week deleted: " + "\n" + weeklyPlannerRepository.getReferenceById(weekId);
        weeklyPlannerRepository.deleteById(weekId);
        return result;
    }

    @Override
    public WeeklyPlanner saveWeeklyPlanner(WeeklyPlanner weeklyPlanner) {

        return weeklyPlannerRepository.saveAndFlush(weeklyPlanner);
    }

    @Override
    public WeeklyPlanner update(Long id, WeeklyPlanner weeklyPlanner) {
        WeeklyPlanner existingWeeklyPlanner = weeklyPlannerRepository.getReferenceById(id);
        BeanUtils.copyProperties(weeklyPlanner, existingWeeklyPlanner, "week_id");
        return weeklyPlannerRepository.saveAndFlush(existingWeeklyPlanner);
    }
}
