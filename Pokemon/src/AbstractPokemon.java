
public abstract class AbstractPokemon implements PokemonInterface {

	@Override
	public String pokemonInfo(Pokemon pokemon) {
		// TODO Auto-generated method stub
		String s = pokemon.getName() + " has " + Integer.toString(pokemon.getHealth()) + " hp and is type " + pokemon.getType(); 
		
		return s;
	}
	
	@Override
	public Pokemon createPokemon(String name, int health, String type) {
		// TODO Auto-generated method stub
		Pokemon p = new Pokemon(name, health, type);
		return p;
	}
	
	
}
