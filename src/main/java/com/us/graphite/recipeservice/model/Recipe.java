package com.us.graphite.recipeservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "recipes")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String ingredients;

    private String instructions;

    private int yield;

    private float prepTime;

    private int userId;

    public Recipe(String title, String ingredients, String instructions, int yield,
                  float prepTime, int userId) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.yield = yield;
        this.prepTime = prepTime;
        this.userId = userId;
    }

}
