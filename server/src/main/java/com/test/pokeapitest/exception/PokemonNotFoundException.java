package com.test.pokeapitest.exception;

public class PokemonNotFoundException extends RuntimeException {
  public PokemonNotFoundException(String message) {
    super(message);
  }
  
}
