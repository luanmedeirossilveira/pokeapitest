package com.test.pokeapitest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonResponse {

  private int id;
  private List<AbilityInfo> abilities;
  @JsonProperty("order")
  private int orderList;
  private String name;
  private Sprites sprites;
}
