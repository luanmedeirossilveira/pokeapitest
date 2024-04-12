package com.test.pokeapitest.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.test.pokeapitest.exception.FavoriteNotFoundException;
import com.test.pokeapitest.exception.FavoriteUniqueViolationException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

  @ExceptionHandler(FavoriteNotFoundException.class)
  public ResponseEntity<ErrorMessage> favoriteNotFoundException(RuntimeException ex, HttpServletRequest request) {

    log.error("Api Error - ", ex);
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .contentType(MediaType.APPLICATION_JSON)
        .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));
  }

  @ExceptionHandler(FavoriteUniqueViolationException.class)
  public ResponseEntity<ErrorMessage> uniqueViolationException(RuntimeException ex, HttpServletRequest request) {

    log.error("Api Error - ", ex);
    return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .contentType(MediaType.APPLICATION_JSON)
        .body(new ErrorMessage(request, HttpStatus.CONFLICT, ex.getMessage()));
  }
}
