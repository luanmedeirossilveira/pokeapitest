package com.test.pokeapitest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.pokeapitest.entity.Pokemon;
import com.test.pokeapitest.web.model.PaginatedPokemonResponse;

@Service
public class PokemonService {

  private static final String POKEAPI_BASE_URL = "https://pokeapi.co/api/v2/";

  private final RestTemplate restTemplate;

  public PokemonService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public PaginatedPokemonResponse findAll(int page, int pageSize) {
    String url = POKEAPI_BASE_URL + "pokemon?offset=" + ((page - 1) * pageSize) + "&limit=" + pageSize;
    PaginatedPokemonResponse response = restTemplate.getForObject(url, PaginatedPokemonResponse.class);
  
    if (response == null) {
      return new PaginatedPokemonResponse();
    }

    return new PaginatedPokemonResponse(response.getResults(), response.getCount(), response.getNext(),
          response.getPrevious());
  }

  public boolean exists(String name) {
    try {
      String url = POKEAPI_BASE_URL + "pokemon/" + name;
      return restTemplate.getForObject(url, Pokemon.class) != null;
    } catch (Exception e) {
      return false;
    }
  }
}
