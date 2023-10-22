package com.zionet.hibernatedemo.controller;

import com.zionet.hibernatedemo.model.*;
import com.zionet.hibernatedemo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }


    @PostMapping
    public void saveOrUpdateRecipe(@RequestBody Recipe recipe) {
        System.out.println("Received recipe: " + recipe);

        recipeService.saveOrUpdateRecipe(recipe);
    }
    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }
}
