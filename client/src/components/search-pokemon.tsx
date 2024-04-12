import { Button, Flex, Heading, Input } from "@chakra-ui/react";
import { SubmitHandler, useForm } from "react-hook-form";
import { PokemonList } from "./pokemon-list";
import { Pagination } from "./pagination";
import { useEffect, useState } from "react";
import { addPokedex, getAllPokemons } from "../services/pokemonService";
import { Pokemon } from "../types";


type SearchPokemon = {
  pokemonName: string;
};

export const SearchPokemon = () => {
  const { register, handleSubmit, watch } = useForm<SearchPokemon>();
  const onSubmit: SubmitHandler<SearchPokemon> = (data) => console.log(data);
  const [pokemons, setPokemons] = useState<Pokemon>({} as Pokemon);
  const [page, setPage] = useState(1);

  const addFavorites = async (name: string) => {
    await addPokedex(name);
  }

  useEffect(() => {
    getAllPokemons(page, 10).then((pokemons) =>
      setPokemons(pokemons.data)
    );
  }, [page]);

  console.log(watch("pokemonName"));

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

      <Flex as="form" onSubmit={handleSubmit(onSubmit)} gap={3}>
        <Input placeholder="Nome do pokemon" {...register("pokemonName")} />
        <Button type="submit">Procurar</Button>
      </Flex>

      <Flex
        minH="30vh"
        gap={2}
        flexDirection="column"
        maxH="50vh"
        overflowY="auto"
      >
        {pokemons?.results?.map((pokemon) => (
          <PokemonList
            key={pokemon.name}
            name={pokemon.name.toUpperCase()}
            onClick={() => {
              addFavorites(pokemon.name)
              window.location.reload()
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
