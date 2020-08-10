
public abstract class AbstractPokemon implements PokemonInterface {

	@Override
	public String pokemonInfo(Pokemon pokemon) {
		// TODO Auto-generated method stub
		String s = pokemon.getName() + " has " + Integer.toString(pokemon.getHealth()) + " hp and is type " + pokemon.getType(); 
		
		return s;
	}

}
