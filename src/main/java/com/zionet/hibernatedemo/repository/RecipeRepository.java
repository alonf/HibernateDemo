package com.zionet.hibernatedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zionet.hibernatedemo.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
