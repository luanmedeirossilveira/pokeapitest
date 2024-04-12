package com.test.pokeapitest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ability {
  private String name;

  // Getters e setters

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
