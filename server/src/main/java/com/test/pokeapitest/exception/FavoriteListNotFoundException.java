package com.test.pokeapitest.exception;

public class FavoriteListNotFoundException extends RuntimeException {
  public FavoriteListNotFoundException(String message) {
    super(message);
  }
  
}
