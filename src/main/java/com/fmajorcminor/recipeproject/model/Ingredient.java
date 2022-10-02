package com.fmajorcminor.recipeproject.model;

import javax.persistence.*;

@Entity(name = "ingredient")
public class Ingredient {

    @Id
    private String ingredient_name;

    private Boolean running_out;
    private Boolean completely_out;
    private String common_vegan_substitute;

    @ManyToOne
    @JoinColumn(name = "starting_week_date")
    private WeeklyPlanner weeklyPlanner;

    public WeeklyPlanner getWeeklyPlanner() {
        return weeklyPlanner;
    }

    public void setWeeklyPlanner(WeeklyPlanner weeklyPlanner) {
        this.weeklyPlanner = weeklyPlanner;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public Boolean getRunning_out() {
        return running_out;
    }

    public void setRunning_out(Boolean running_out) {
        this.running_out = running_out;
    }

    public Boolean getCompletely_out() {
        return completely_out;
    }

    public void setCompletely_out(Boolean completely_out) {
        this.completely_out = completely_out;
    }

    public String getCommon_vegan_substitute() {
        return common_vegan_substitute;
    }

    public void setCommon_vegan_substitute(String common_vegan_substitute) {
        this.common_vegan_substitute = common_vegan_substitute;
    }


}
