
public class PokemonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pokedex pd1 = new Pokedex();
		Pokedex pd2 = new Pokedex();
		
		pd1.createPokemon("Gengar", 100, "Dark");
		pd1.createPokemon("Ghastly", 50, "Dark");
		pd1.createPokemon("Weedle", 20, "Grass");
		pd1.createPokemon("Weedle", 20, "Grass");
		
		pd2.createPokemon("Gengar", 100, "Dark");
		pd2.createPokemon("Ghastly", 50, "Dark");
		
		pd1.listPokemon();
		pd2.listPokemon();
	}

}
