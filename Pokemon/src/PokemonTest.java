
public class PokemonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pokedex pd1 = new Pokedex();
		Pokedex pd2 = new Pokedex();
		
		pd1.addPokemon("Gengar", 100, "Dark");
		pd1.addPokemon("Ghastly", 50, "Dark");
		pd1.addPokemon("Weedle", 20, "Grass");
		pd1.addPokemon("Weedle", 20, "Grass");
		
		pd2.addPokemon("Gengar", 100, "Dark");
		pd2.addPokemon("Ghastly", 50, "Dark");
		
		pd1.listPokemon();
		pd2.listPokemon();
	}

}
