package com.example.lab9.Controller;

import com.example.lab9.Model.Cocktail;
import com.example.lab9.Service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class CocktailController {

    private final CocktailService cocktailService;

    @Autowired
    public CocktailController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping("/cocktails")
    public String obtenerCocteles(Model model) {
        List<Cocktail> cocktails = cocktailService.obtenerListaDeCocteles();
        // Dividir los cócteles en sublistas de 3
        List<List<Cocktail>> cocktailsInRows = new ArrayList<>();
        for (int i = 0; i < cocktails.size(); i += 3) {
            int end = Math.min(i + 3, cocktails.size());
            cocktailsInRows.add(cocktails.subList(i, end));
        }
        model.addAttribute("cocktailsInRows", cocktailsInRows);
        return "lista-cocteles";
    }


}