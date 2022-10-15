package com.fmajorcminor.recipeproject.controller;

import com.fmajorcminor.recipeproject.model.Recipe;
import com.fmajorcminor.recipeproject.repository.RecipeRepository;
import com.fmajorcminor.recipeproject.service.RecipeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestMapping(path="/api/recipes")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RecipeController {

    private final static Logger logger = Logger.getLogger(RecipeController.class.getName());

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        logger.log(Level.INFO, "Get all recipes API called");
        return recipeService.getAllRecipes();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Recipe get(@PathVariable Long id) {
        logger.log(Level.INFO, "Get one recipe API called");
        return recipeService.getOneRecipe(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe create(@RequestBody final Recipe recipe) {
        logger.log(Level.INFO, "Add recipe API called");
        return recipeService.addRecipe(recipe);
    }

    @DeleteMapping(value = "{id}")
    public String delete(@PathVariable Long id) {
        logger.log(Level.INFO, "Delete recipe API called");
        return recipeService.deleteRecipe(id);
    }

    @PutMapping(value = "{id}")
    public Recipe update(@PathVariable Long id, @RequestBody Recipe recipe) {
        logger.log(Level.INFO, "Update recipe API called");
        return recipeService.updateRecipe(id, recipe);
    }




}
