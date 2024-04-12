export type Pokemon = {
  count: number;
  next: string;
  previous: string;
  results: {
    name: string;
    id: number;
  }[];
};

export type Favorites = {
  id: number;
	name: string;
	abilities: string[];
	orderList: number;
	sprite: string;
}