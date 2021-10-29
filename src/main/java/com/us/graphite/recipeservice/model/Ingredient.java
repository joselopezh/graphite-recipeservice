package com.us.graphite.recipeservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Ingredient {

    private int order;

    private String name;

    private String quantity;
}
