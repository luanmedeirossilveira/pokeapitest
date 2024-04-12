package com.test.pokeapitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.pokeapitest.entity.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
  
}
