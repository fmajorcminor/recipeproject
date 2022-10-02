package com.fmajorcminor.recipeproject.repository;

import com.fmajorcminor.recipeproject.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
