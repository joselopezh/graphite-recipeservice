package com.us.graphite.recipeservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Instruction {

    private int step;

    private String direction;
}
