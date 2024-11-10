package com.example.lab9.Service;

import com.example.lab9.Model.Cocktail;
import com.example.lab9.Model.CocktailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CocktailService {

    private static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1";

    @Autowired
    private RestTemplate restTemplate;

    public List<Cocktail> obtenerListaDeCocteles() {
        String url = BASE_URL + "/filter.php?c=Cocktail";
        CocktailResponse response = restTemplate.getForObject(url, CocktailResponse.class);
        if (response != null && response.getDrinks() != null) {
            return response.getDrinks().stream().limit(12).toList();
        }
        return List.of();
    }
}