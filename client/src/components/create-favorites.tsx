import { Flex, Grid, Heading } from "@chakra-ui/react";
import { getAllPokedex } from "../services/pokemonService";
import { useEffect, useState } from "react";
import { Favorites } from "../types";
import { PokemonCard } from "./pokemon-card";
import { toast } from "react-toastify";

export const CreateFavorites = () => {
  const [favorites, setFavorites] = useState<Favorites[]>([]);

  useEffect(() => {
    getAllPokedex()
      .then((pokemons) => setFavorites(pokemons.data))
      .catch((error) => toast.error(error?.response?.data?.message));
  }, []);
  
  return (
    <Flex
      flexDirection="column"
      gap={6}
      border="1px solid"
      borderColor="gray"
      p={6}
      borderRadius={6}
    >
      <Heading size="md">Favoritos</Heading>

      <Grid templateColumns={"repeat(2, 1fr)"} gap={6} maxH="60vh" overflowY="auto">
        {favorites?.map((pokemon) => (
          <PokemonCard 
            key={pokemon.id}
            abilities={pokemon.abilities}
            name={pokemon.name}
            orderList={pokemon.orderList}
            sprite={pokemon.sprite}
          />
        ))}
      </Grid>
    </Flex>
  );
};
