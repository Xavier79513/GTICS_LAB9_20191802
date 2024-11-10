package com.example.lab9.Service;

import com.example.lab9.Model.Cocktail;
import com.example.lab9.Model.CocktailDetail;
import com.example.lab9.Model.CocktailDetailResponse;
import com.example.lab9.Model.CocktailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

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

    @Autowired
    public CocktailService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CocktailDetail obtenerDetalleCoctel(String id) {
        String url = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + id;
        ResponseEntity<CocktailDetailResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, null, CocktailDetailResponse.class);

        return Objects.requireNonNull(response.getBody()).getDrinks().get(0);
    }
}