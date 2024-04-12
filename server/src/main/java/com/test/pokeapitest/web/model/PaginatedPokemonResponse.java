package com.test.pokeapitest.web.model;

import java.util.List;

import com.test.pokeapitest.entity.Pokemon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginatedPokemonResponse {
  private List<Pokemon> results;
  private int count;
  private String next;
  private String previous;

  public PaginatedPokemonResponse(List<Pokemon> pokemons, int count, String next, String previous) {
    this.results = pokemons;
    this.count = count;
    this.next = next;
    this.previous = previous;
  }

  public PaginatedPokemonResponse() {
  }

}
