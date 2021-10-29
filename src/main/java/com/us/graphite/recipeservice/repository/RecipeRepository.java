package com.us.graphite.recipeservice.repository;

import com.us.graphite.recipeservice.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> { }