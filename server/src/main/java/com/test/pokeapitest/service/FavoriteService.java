package com.test.pokeapitest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.pokeapitest.entity.Favorites;
import com.test.pokeapitest.exception.FavoriteUniqueViolationException;
import com.test.pokeapitest.models.*;
import com.test.pokeapitest.repository.FavoriteRepository;

@Service
public class FavoriteService {

  private static final String POKEAPI_BASE_URL = "https://pokeapi.co/api/v2/";
  private final RestTemplate restTemplate;
  private final FavoriteRepository favoriteRepository;

  public FavoriteService(FavoriteRepository favoriteRepository, RestTemplate restTemplate) {
    this.favoriteRepository = favoriteRepository;
    this.restTemplate = restTemplate;
  }

  public PokemonResponse fetchPokemonDetails(String pokemonName) {
    return restTemplate.getForObject(POKEAPI_BASE_URL + "pokemon/" + pokemonName, PokemonResponse.class);
  }

  public Favorites save(String pokemonName) {
    try {
      Favorites favorites = new Favorites();
      PokemonResponse pokemonResponse = fetchPokemonDetails(pokemonName);

      if (favoriteRepository.findByName(pokemonName) != null) {
        throw new FavoriteUniqueViolationException("Pokemon " + pokemonName + " já existe em sua lista");
      }
      
      // Nome
      favorites.setName(pokemonName);
      
      // Habilidades
      List<String> abilities = new ArrayList<>();
      for (AbilityInfo ability : pokemonResponse.getAbilities()) {
        abilities.add(ability.getAbility().getName());
      }
      favorites.setAbilities(abilities);

      // Ordem
      favorites.setOrderList(pokemonResponse.getOrderList());

      // Sprite
      favorites.setSprite(pokemonResponse.getSprites().getFrontDefault());

      return favoriteRepository.save(favorites);

    } catch (Exception e) {
      throw new FavoriteUniqueViolationException("Pokemon " + pokemonName + " já existe em sua lista");
    }
  }

  public List<Favorites> findAll() {
    return favoriteRepository.findAll();
  }

  public Favorites findByName(String name) {
    return favoriteRepository.findByName(name);
  }
}
