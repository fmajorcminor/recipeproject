package com.fmajorcminor.recipeproject.component;

import com.fmajorcminor.recipeproject.model.Recipe;
import com.fmajorcminor.recipeproject.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final RecipeRepository recipeRepository;

    @Autowired
    public DatabaseLoader(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    @Override
    public void run(String... args) throws Exception {
//        this.recipeRepository.save(new Recipe("Super yummy food", "American","test.xyz",
//                "hot", "breakfast"));
    }
}
