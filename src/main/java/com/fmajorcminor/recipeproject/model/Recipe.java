package com.fmajorcminor.recipeproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity(name = "recipe")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //helps with more deserialization issues - not sure what
public class Recipe {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long recipe_id;

    private String title;
    private String culture;
    private String link;
    private String temperature;
    private String mealType;
    private Boolean favorite;

    @ManyToOne
    @JoinColumn(name = "starting_week_date")
    private WeeklyPlanner weeklyPlanner;


    public WeeklyPlanner getWeeklyPlanner() {
        return weeklyPlanner;
    }

    public void setWeeklyPlanner(WeeklyPlanner weeklyPlanner) {
        this.weeklyPlanner = weeklyPlanner;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public Long getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Long id) {
        this.recipe_id = id;
    }
}
