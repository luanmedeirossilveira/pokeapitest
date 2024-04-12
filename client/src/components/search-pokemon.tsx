import { Flex, Heading } from "@chakra-ui/react";
import { PokemonList } from "./pokemon-list";
import { Pagination } from "./pagination";
import { useEffect, useState } from "react";
import { addPokedex, getAllPokemons } from "../services/pokemonService";
import { Pokemon } from "../types";
import { toast } from "react-toastify";

type SearchPokemon = {
  pokemonName: string;
};

export const SearchPokemon = () => {
  const [pokemons, setPokemons] = useState<Pokemon>({} as Pokemon);
  const [page, setPage] = useState(1);

  const addFavorites = async (name: string) => {
    await addPokedex(name)
      .then(() => {
        toast.success("Adicionado aos favoritos")

        setTimeout(() => {
          window.location.reload();
        }, 2000);
      })
      .catch((error) => toast.error(error?.response?.data?.message));
  };

  useEffect(() => {
    getAllPokemons(page, 10)
      .then((pokemons) => setPokemons(pokemons.data))
      .catch((error) => toast.error("Erro:", error.message));
  }, [page]);

  return (
    <Flex
      flexDirection="column"
      gap={6}
      border="1px solid"
      borderColor="gray"
      p={6}
      borderRadius={6}
    >
      <Heading size="md">Procurar pokemon</Heading>

      <Flex
        minH="30vh"
        gap={2}
        flexDirection="column"
        maxH="60vh"
        overflowY="auto"
      >
        {pokemons?.results?.map((pokemon) => (
          <PokemonList
            key={pokemon.name}
            name={pokemon.name.toUpperCase()}
            onClick={() => {
              addFavorites(pokemon.name);
            }}
          />
        ))}

        {pokemons?.results?.length > 0 && (
          <Pagination
            page={page}
            setPage={(page) => setPage(page)}
            lastPage={pokemons?.count / 10}
          />
        )}
      </Flex>
    </Flex>
  );
};
