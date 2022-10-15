package com.fmajorcminor.recipeproject.service;

import com.fmajorcminor.recipeproject.model.Ingredient;
import com.fmajorcminor.recipeproject.model.Recipe;

import java.util.List;

public interface IIngredientService {
    List<Ingredient> getAllRecipes();
    Ingredient getOneRecipe(Long id);
    Ingredient addRecipe(Ingredient ingredientIn);
    Ingredient deleteRecipe(Long id);
    Ingredient updateRecipe(Long id, Ingredient ingredientIn);
}
