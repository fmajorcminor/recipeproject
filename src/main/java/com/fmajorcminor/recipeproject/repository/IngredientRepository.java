package com.fmajorcminor.recipeproject.repository;

import com.fmajorcminor.recipeproject.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
