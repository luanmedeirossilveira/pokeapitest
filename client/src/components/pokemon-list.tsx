import { Button, Flex, Text } from "@chakra-ui/react";

interface PokemonListProps {
  name: string;
  onClick: () => void;
}

export const PokemonList = ({ name, onClick }: PokemonListProps) => {
  return (
    <Flex
      border="1px solid"
      borderColor="gray.100"
      p={6}
      borderRadius={6}
      justifyContent="space-between"
    >
      <Text size="md">{name}</Text>

      <Button onClick={onClick}>+ Favoritos</Button>
    </Flex>
  );
}