import { Button, Flex, Text } from "@chakra-ui/react";

interface PaginationProps {
  page: number;
  setPage: (page: number) => void;
  lastPage: number;
}

export const Pagination = ({ page, setPage, lastPage }: PaginationProps) => {
  const prevPage = () => {
    if (page > 1) {
      setPage(page - 1);
    }
  };

  const nextPage = () => {
    if (page < lastPage) {
      setPage(page + 1);
    }
  };

  return (
    <Flex gap={3} justifyContent={"center"}>
      <Button disabled={page <= 1} onClick={prevPage}>
        Anterior
      </Button>
      <Flex
        justifyContent="center"
        alignItems="center"
        py={1}
        px={2}
        border="1px solid"
        borderColor="gray.100"
        borderRadius={6}
      >
        <Text>{page}</Text>
      </Flex>
      <Button disabled={page >= lastPage} onClick={nextPage}>
        Próximo
      </Button>
    </Flex>
  );
};
