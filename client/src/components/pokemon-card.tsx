import { Card, Flex, Image, Text } from "@chakra-ui/react";

interface PokemonCardProps {
  abilities: string[];
  name: string;
  orderList: number;
  sprite: string;
}

export const PokemonCard = ({
  abilities,
  name,
  sprite,
  orderList,
}: PokemonCardProps) => {
  return (
    <Card border="1px solid" borderColor="gray.100" p={6}>
      <Flex
        justifyContent="center"
        alignItems="center"
        border="1px solid"
        borderColor="gray.100"
        rounded="full"
        w={10}
        h={10}
      >
        <Text>{orderList}</Text>
      </Flex>
      <Flex justifyContent="space-evenly" alignItems="center">
        <Image src={sprite} alt="logo" w="100px" h="100px" />
        <Text size="2xl" fontWeight="bold">
          {name}
        </Text>
      </Flex>
      <Text>Habilidades: </Text>
      <Flex bg={"gray.100"} p={3} border="1px solid" borderRadius={6} flexDirection="column">
        {abilities.map((ability) => {
          const text = `(${ability})`;
          return <Text>{text}</Text>;
        })}
      </Flex>
    </Card>
  );
};
