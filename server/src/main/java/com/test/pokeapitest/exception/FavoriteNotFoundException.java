package com.test.pokeapitest.exception;

public class FavoriteNotFoundException extends RuntimeException {
  public FavoriteNotFoundException(String message) {
    super(message);
  }
  
}
