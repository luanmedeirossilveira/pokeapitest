package com.test.pokeapitest.exception;

public class FavoriteUniqueViolationException extends RuntimeException {
  
  public FavoriteUniqueViolationException(String message) {
    super(message);
  }
}
