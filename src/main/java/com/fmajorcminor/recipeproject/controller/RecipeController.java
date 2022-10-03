package com.fmajorcminor.recipeproject.controller;

import com.fmajorcminor.recipeproject.model.Recipe;
import com.fmajorcminor.recipeproject.repository.RecipeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestMapping(path="/api/recipes")
@RestController
public class RecipeController {

    private final static Logger logger = Logger.getLogger(RecipeController.class.getName());

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        logger.log(Level.INFO, "Get all recipes API called");
        return recipeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Recipe get(@PathVariable Long id) {
        return recipeRepository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe create(@RequestBody final Recipe recipe) {
        return recipeRepository.saveAndFlush(recipe);
    }

    @DeleteMapping(value = "{id}")
    public String delete(@PathVariable Long id) {
        recipeRepository.deleteById(id);
        return String.format("Recipe with id of %s is successfully deleted", id);
    }

    @PutMapping(value = "{id}")
    public Recipe update(@PathVariable Long id, @RequestBody Recipe recipe) {
        Recipe existingRecipe = recipeRepository.getReferenceById(id);
        BeanUtils.copyProperties(recipe, existingRecipe, "recipe_id");
        return recipeRepository.saveAndFlush(existingRecipe);
    }




}
