package com.fmajorcminor.recipeproject.model;

import javax.persistence.*;

@Entity(name = "ingredient")
public class Ingredient {

    @Id
    @Column(name = "ingredient_id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingredient_id;

    private String ingredient_name;

    private Boolean running_out;
    private Boolean completely_out;
    private String common_vegan_substitute;

    public Long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Long ingredient_id) {
        this.ingredient_id = ingredient_id;
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
