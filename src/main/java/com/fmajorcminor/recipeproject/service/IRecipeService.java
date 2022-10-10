package com.fmajorcminor.recipeproject.service;

import com.fmajorcminor.recipeproject.model.Recipe;

import java.util.List;

public interface IRecipeService {
    List<Recipe> getAllRecipes();
    Recipe getOneRecipe(Long id);
    Recipe addRecipe(Recipe recipeIn);
    String deleteRecipe(Long id);
    Recipe updateRecipe(Long id, Recipe recipeIn);
}
