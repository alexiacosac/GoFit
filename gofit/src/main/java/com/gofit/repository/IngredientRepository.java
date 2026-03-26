package com.gofit.repository;

import com.gofit.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    // Aceasta este metoda care lipsea:
    // "In" îi spune lui Spring să caute ingrediente care au suitability
    // într-o listă de valori (ex: ['GAIN_WEIGHT', 'MAINTAIN'])
    List<Ingredient> findByCategoryAndSuitabilityIn(String category, List<String> suitabilities);

    // Păstrează și vechea metodă dacă o mai folosești undeva
    List<Ingredient> findByCategory(String category);
}