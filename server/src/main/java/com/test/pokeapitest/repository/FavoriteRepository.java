package com.test.pokeapitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.pokeapitest.entity.Favorites;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorites, Long> {
  Favorites findByName(String name);
}
