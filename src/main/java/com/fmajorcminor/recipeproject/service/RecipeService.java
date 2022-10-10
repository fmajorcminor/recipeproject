package com.fmajorcminor.recipeproject.service;

import com.fmajorcminor.recipeproject.model.Recipe;
import com.fmajorcminor.recipeproject.repository.RecipeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService implements IRecipeService{

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getOneRecipe(Long id) {
        return recipeRepository.getReferenceById(id);
    }

    @Override
    public Recipe addRecipe(Recipe recipeIn) {
        return recipeRepository.saveAndFlush(recipeIn);
    }

    @Override
    public String deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
        return String.format("Recipe with id of %s is successfully deleted", id);
    }

    @Override
    public Recipe updateRecipe(Long id, Recipe recipeIn) {
        Recipe existingRecipe = recipeRepository.getReferenceById(id);
        BeanUtils.copyProperties(recipeIn, existingRecipe, "recipe_id");
        return recipeRepository.saveAndFlush(existingRecipe);
    }
}
