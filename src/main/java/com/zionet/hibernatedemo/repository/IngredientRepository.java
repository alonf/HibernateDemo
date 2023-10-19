package com.zionet.hibernatedemo.repository;

import com.zionet.hibernatedemo.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
