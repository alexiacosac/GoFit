package com.gofit.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category; // BREAKFAST_BASE, PROTEIN, CARB, VEGGIE

    @Column(name = "calories_per_100g")
    private Integer caloriesPer100g;

    @Column(name = "protein_per_100g")
    private Integer proteinPer100g;

    @Column(name = "carbs_per_100g")
    private Integer carbsPer100g;

    @Column(name = "fats_per_100g")
    private Integer fatsPer100g;

    private String suitability;
}