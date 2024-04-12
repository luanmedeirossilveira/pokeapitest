package com.test.pokeapitest.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.pokeapitest.entity.Favorites;
import com.test.pokeapitest.service.FavoriteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Tag(name = "Favorites", description = "Operações de Favoritos")
@RestController
@CrossOrigin("*")
@RequestMapping("/api/favorites")
public class FavoriteController {
  
  private FavoriteService service;

  public FavoriteController(FavoriteService service) {
    this.service = service;
  }
  
  @Operation(summary = "Salva novo Pokemon", description = "Salva um novo pokemon na lista de favoritos")
  @PostMapping("/{pokemonName}")
  public Favorites save(@PathVariable String pokemonName) {
    return service.save(pokemonName);
  }
  
  @Operation(summary = "Lista de Favoritos", description = "Retorna a lista de favoritos")
  @GetMapping
  public List<Favorites> findAll() {
    return service.findAll();
  }
}
