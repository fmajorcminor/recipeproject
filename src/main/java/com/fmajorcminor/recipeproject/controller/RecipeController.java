package com.fmajorcminor.recipeproject.controller;

import antlr.StringUtils;
import com.fmajorcminor.recipeproject.model.Recipe;
import com.fmajorcminor.recipeproject.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.apache.logging.log4j.util.Strings.isBlank;

@RequestMapping(path="/api")
@Controller
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @PostMapping(path="/addRecipe")
    public @ResponseBody String addNewRecipe (@RequestParam String title, @RequestParam String culture, @RequestParam String link,
                                              @RequestParam String temperature, @RequestParam String mealType) {
        Recipe recipe = new Recipe(title, culture, link, temperature, mealType);
        recipeRepository.save(recipe);

        return "Saved recipe in DB";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/allRecipes")
    public @ResponseBody Iterable<Recipe> getAllRecipes(@RequestParam(required = false, name = "culture") String culture) {
        if (!isBlank(culture)) {
            return recipeRepository.findRecipeByCulture(culture);
        }
        return recipeRepository.findAll();
    }

}
