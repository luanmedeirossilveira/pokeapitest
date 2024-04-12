import { Header } from './components/header'
import { Box, Grid } from '@chakra-ui/react'
import { SearchPokemon } from './components/search-pokemon';
import { CreateFavorites } from './components/create-favorites';

function App() {
  return (
    <Box minH="100vh">
      <Header />

      <Grid templateColumns={"repeat(2, 1fr)"} gap={6} p={6}>
        <SearchPokemon />

        <CreateFavorites />
      </Grid>
    </Box>
  );
}

export default App
