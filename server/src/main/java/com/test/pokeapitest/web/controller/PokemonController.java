package com.test.pokeapitest.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.test.pokeapitest.service.PokemonService;
import com.test.pokeapitest.web.model.PaginatedPokemonResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "Pokemons", description = "Operações de Pokemons")
@RestController
@CrossOrigin("*")
@RequestMapping("/api/pokemons")
public class PokemonController {

  private PokemonService service;

  public PokemonController(PokemonService pokemonService) {
    this.service = pokemonService;
  }

  @Operation(summary = "Lista de Pokemons", description = "Retorna a lista de pokemons da PokeAPI")
  @GetMapping
  public PaginatedPokemonResponse getAll(@RequestParam int page, @RequestParam int pageSize) {
    if (page < 1 || pageSize < 1) {
      throw new IllegalArgumentException("Pagina e tamanho da pagina devem ser maiores ou iguais a 1");
    }
    
    return service.findAll(page, pageSize);
  }
}
