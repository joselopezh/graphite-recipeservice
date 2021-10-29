package com.us.graphite.recipeservice.utils;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.us.graphite.recipeservice.model.Ingredient;
import com.us.graphite.recipeservice.model.Instruction;

import java.util.ArrayList;

public class Utils {
    private static Gson gson = new Gson();
    public static String ingredientsToJsonString(ArrayList<Ingredient> ingredients) {
        JsonArray jsonArray = new JsonArray();

        if (ingredients != null)
            ingredients.forEach(ingredient -> {
                jsonArray.add(gson.toJson(ingredient, Ingredient.class));
            });

        return jsonArray.toString();
    }

    public static String instructionsToJsonString(ArrayList<Instruction> instructions) {
        JsonArray jsonArray = new JsonArray();

        if (instructions != null)
            instructions.forEach(instruction -> {
                jsonArray.add(gson.toJson(instruction, Instruction.class));
            });

        return jsonArray.toString();
    }
}
