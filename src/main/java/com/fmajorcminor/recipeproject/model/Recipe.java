package com.fmajorcminor.recipeproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity(name = "recipe")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //helps with more deserialization issues - not sure what
public class Recipe {


    @Id
    @Column(name = "recipe_id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recipe_id;

    @NotNull
    private String title;
    private String culture;
    @NotNull
    private String link;
    private String temperature;
    private String mealType;
    private Boolean favorite;

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

    @Override
    public String toString() {
        return "Recipe{" +
                "recipe_id=" + recipe_id +
                ", title='" + title + '\'' +
                ", culture='" + culture + '\'' +
                ", link='" + link + '\'' +
                ", temperature='" + temperature + '\'' +
                ", mealType='" + mealType + '\'' +
                ", favorite=" + favorite +
                '}';
    }
}
