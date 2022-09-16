package com.fmajorcminor.recipeproject.repository;

import com.fmajorcminor.recipeproject.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findRecipeByCulture(String culture);
}
