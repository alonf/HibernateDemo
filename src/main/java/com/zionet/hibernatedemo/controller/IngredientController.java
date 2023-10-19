package com.zionet.hibernatedemo.controller;

import com.zionet.hibernatedemo.model.Ingredient;
import com.zionet.hibernatedemo.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return ingredientService.getIngredientById(id);
    }

    @PostMapping
    public void saveOrUpdateIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.saveOrUpdateIngredient(ingredient);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
    }
}
