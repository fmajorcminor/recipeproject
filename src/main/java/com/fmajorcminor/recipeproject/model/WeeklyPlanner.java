package com.fmajorcminor.recipeproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "weekly_planner")
public class WeeklyPlanner {
    @Id
    private LocalDate starting_week_date;

    private Boolean week_is_planned;

    @OneToMany(mappedBy = "weeklyPlanner")
    private List<Ingredient> ingredientList;

    @OneToMany(mappedBy = "weeklyPlanner")
    private List<Recipe> recipeList;

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public LocalDate getStarting_week_date() {
        return starting_week_date;
    }

    public void setStarting_week_date(LocalDate starting_week_date) {
        this.starting_week_date = starting_week_date;
    }

    public Boolean getWeek_is_planned() {
        return week_is_planned;
    }

    public void setWeek_is_planned(Boolean week_is_planned) {
        this.week_is_planned = week_is_planned;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}
