package com.test.pokeapitest.web.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ErrorMessage {

  private String path;

  private String method;

  private int status;

  private String statusText;

  private String message;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Map<String, String> errors;

  public ErrorMessage(HttpServletRequest request, HttpStatus status, String message) {
    this.path = request.getRequestURI();
    this.method = request.getMethod();
    this.status = status.value();
    this.statusText = status.getReasonPhrase();
    this.message = message;
  }

  public ErrorMessage(HttpServletRequest request, HttpStatus status, String message, BindingResult result) {
    this.path = request.getRequestURI();
    this.method = request.getMethod();
    this.status = status.value();
    this.statusText = status.getReasonPhrase();
    this.message = message;
    addErrors(result);
  }

  public ErrorMessage() {
  }

  public void addErrors(BindingResult result) {
    this.errors = new HashMap<>();

    result.getFieldErrors().forEach(error -> this.errors.put(error.getField(), error.getDefaultMessage()));
  }
}
