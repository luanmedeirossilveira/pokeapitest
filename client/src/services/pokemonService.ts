import axios from "axios";
import type { Favorites, Pokemon } from "../types";

const URL_API = "http://localhost:8080/api";

export interface PokemonPromise {
  data: Pokemon
}

export interface FavoritesPromise {
  data: Favorites[]
}

export interface FavoritePromise {
  data: Favorites;
}

export const getAllPokemons = async (page: number, pageSize: number): Promise<PokemonPromise> => {
  const response = await axios.get(`${URL_API}/pokemons?page=${page}&pageSize=${pageSize}`);
  return response;
}

export const addPokedex = async (name: string): Promise<FavoritePromise> => {
  const response = await axios.post(`${URL_API}/favorites/${name}`);
  return response;
};

export const getAllPokedex = async (): Promise<FavoritesPromise> => {
  const response = await axios.get(`${URL_API}/favorites`);
  return response;
};