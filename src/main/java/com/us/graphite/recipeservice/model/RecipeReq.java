package com.us.graphite.recipeservice.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
public class RecipeReq implements Serializable {

    private long id;

    private String title;

    private ArrayList<Ingredient> ingredients;

    private ArrayList<Instruction> instructions;

    private int yield;

    private float prepTime;

    private int userId;
}
