package com.fmajorcminor.recipeproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.FilterJoinTable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "weekly_planner")
public class WeeklyPlanner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long week_id;

    @Column(name = "starting_week_date", unique = true)
    private LocalDate starting_week_date;

    private Boolean week_is_planned;

    @OneToMany
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredientList;

    @OneToMany
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "recipe_id"))//, referencedColumnName = "starting_week_date")
    private Set<Recipe> recipeList;

    @JsonManagedReference(value = "ingredientList") // this prevents infinite recursion
    public Set<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(Set<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public LocalDate getStarting_week_date() {
        return starting_week_date;
    }

    public void setStarting_week_date(LocalDate starting_week_date) {
        this.starting_week_date = starting_week_date;
    }

    public Long getWeekId() {
        return week_id;
    }

    public void setWeekId(Long week_id) {
        this.week_id = week_id;
    }

    public Boolean getWeek_is_planned() {
        return week_is_planned;
    }

    public void setWeek_is_planned(Boolean week_is_planned) {
        this.week_is_planned = week_is_planned;
    }

    public Set<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(Set<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}
