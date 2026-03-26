package com.gofit.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dayOfWeek; // Monday, Tuesday...
    private String mealType;  // Breakfast, Lunch, Dinner, Snack
    private String name;
    private String ingredients;
    private Integer calories;
    private Integer protein;
    private Integer carbs;
    private Integer fats;

    @Enumerated(EnumType.STRING)
    private Goal targetGoal; // LOSE_WEIGHT, BUILD_MUSCLE, etc.
}