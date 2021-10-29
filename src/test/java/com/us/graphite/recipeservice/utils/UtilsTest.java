package com.us.graphite.recipeservice.utils;

import com.us.graphite.recipeservice.model.Ingredient;
import com.us.graphite.recipeservice.model.Instruction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class UtilsTest {

    @Test
    void givenArrayIngredientsThenReturnIngredientsJsonString() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(Ingredient
                .builder()
                .order(1)
                .name("Ingredient test")
                .quantity("1 cup")
                .build());

        String ingredientsString = Utils.ingredientsToJsonString(ingredients);
        String expectedString= new String("[\"{\\\"order\\\":1,\\\"name\\\":\\\"Ingredient test\\\",\\\"quantity\\\":\\\"1 cup\\\"}\"]");

        Assertions.assertEquals(ingredientsString, expectedString);
    }

    @Test
    void givenNullThenReturnIngredientsJsonString() {
        String ingredientsString = Utils.ingredientsToJsonString(null);
        String expectedString= new String("[]");

        Assertions.assertEquals(ingredientsString, expectedString);
    }

    @Test
    void givenArrayInstructionsThenReturnInstructionsJsonString() {
        ArrayList<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.builder()
                .step(1)
                .direction("Test direction")
                .build());

        String instructionsString = Utils.instructionsToJsonString(instructions);
        String expectedString= new String("[\"{\\\"step\\\":1,\\\"direction\\\":\\\"Test direction\\\"}\"]");

        Assertions.assertEquals(instructionsString, expectedString);
    }

    @Test
    void givenNullThenReturnInstructionJsonString() {
        String instructionsString = Utils.instructionsToJsonString(null);
        String expectedString= new String("[]");

        Assertions.assertEquals(instructionsString, expectedString);
    }

}
