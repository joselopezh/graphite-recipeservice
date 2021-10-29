package com.us.graphite.recipeservice.controller;


import com.us.graphite.recipeservice.utils.Utils;
import com.us.graphite.recipeservice.model.Recipe;
import com.us.graphite.recipeservice.model.RecipeReq;
import com.us.graphite.recipeservice.repository.RecipeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
@Api(value = "Recipes service", description = "This API handle Recipes CRUD")
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    /**
     * GET get all recipes
     * @return HTTP Response - json recipe that contain all recipes
     * */
    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    @ApiOperation(value = "Get recipes", notes = "Return all recipes")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "All recipes") })
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        try {
            List<Recipe> recipes = new ArrayList<>();

            recipeRepository.findAll().forEach(recipes::add);

            if (recipes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(recipes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * GET get recipe by Id
     * @input Json recipeId - Recipe Id
     * @return HTTP Response - json recipe that contain unique Id recipe
     * */
    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get recipe", notes = "Return unique recipes")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Unique recipe") })
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") long id) {
        Optional<Recipe> recipeData = recipeRepository.findById(id);

        if (recipeData.isPresent()) {
            return new ResponseEntity<>(recipeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * POST service to create new Recipe
     * @input Json inputRecipe - json recipe that contain a recipe
     * @return HTTP Response - json recipe that contains a new recipe
     * */
    @RequestMapping(value = "/recipes", method = RequestMethod.POST)
    @ApiOperation(value = "Post recipe", notes = "Return a new recipe")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "New recipe created") })
    public ResponseEntity<Recipe> createRecipe(@RequestBody RecipeReq recipe) {
        try {
            Recipe recipeRes = recipeRepository
                    .save(new Recipe(recipe.getTitle(), Utils.ingredientsToJsonString(recipe.getIngredients()),
                            Utils.instructionsToJsonString(recipe.getInstructions()),
                            recipe.getYield(), recipe.getPrepTime(), recipe.getUserId()));
            return new ResponseEntity<>(recipeRes, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * PUT service to update a Recipe
     * @input Json inputRecipe - json recipe that contains a recipe
     * @return HTTP Response - json recipe thatan updated recipe
     * */
    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Put recipe", notes = "Return an updated recipe")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Recipe updated") })
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") long id, @RequestBody RecipeReq recipe) {
        Optional<Recipe> recipeData = recipeRepository.findById(id);

        if (recipeData.isPresent()) {
            if (recipeData.get().getUserId() == recipe.getUserId()) {
                Recipe recipeRes = recipeData.get();
                recipeRes.setTitle(recipe.getTitle());
                recipeRes.setIngredients(Utils.ingredientsToJsonString(recipe.getIngredients()));
                recipeRes.setInstructions(Utils.instructionsToJsonString(recipe.getInstructions()));
                recipeRes.setYield(recipe.getYield());
                recipeRes.setPrepTime(recipe.getPrepTime());

                return new ResponseEntity<>(recipeRepository.save(recipeRes), HttpStatus.OK);
            } else {
                return new ResponseEntity("Can not update recipe from other user.", HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
