package com.zionet.hibernatedemo.service;

import com.zionet.hibernatedemo.model.Ingredient;
import com.zionet.hibernatedemo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    // Fetch all ingredients
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    // Fetch a single ingredient by ID
    public Ingredient getIngredientById(Long id) {
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(id);
        return optionalIngredient.orElse(null);
    }

    // Save or update an ingredient
    public void saveOrUpdateIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    // Delete an ingredient by ID
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
