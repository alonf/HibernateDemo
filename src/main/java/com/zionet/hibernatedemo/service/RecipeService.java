package com.zionet.hibernatedemo.service;

import com.zionet.hibernatedemo.model.Recipe;
import com.zionet.hibernatedemo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    // Fetch all recipes
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    // Fetch a single recipe by ID
    public Recipe getRecipeById(Long id) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        return optionalRecipe.orElse(null);
    }

    // Save or update a recipe
    public void saveOrUpdateRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    // Delete a recipe by ID
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}
