package com.example.lab9.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CocktailDetail {
    private String strDrink;
    private String strCategory;
    private String strInstructions;
    private String strAlcoholic;
    private String strGlass;
    private String strDrinkThumb;
    private List<String> strIngredient = new ArrayList<>();
    private List<String> strMeasure = new ArrayList<>();

    public List<String> getIngredientsWithMeasures() {
        List<String> ingredientsWithMeasures = new ArrayList<>();

        for (int i = 0; i < strIngredient.size(); i++) {
            String ingredient = strIngredient.get(i);
            String measure = i < strMeasure.size() ? strMeasure.get(i) : "Al gusto";
            ingredientsWithMeasures.add(ingredient + " - " + measure);
        }

        return ingredientsWithMeasures;
    }
}