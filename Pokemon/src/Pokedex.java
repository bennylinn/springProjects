import java.util.*;

public class Pokedex extends AbstractPokemon{
	private ArrayList<Pokemon> myPokemons;
	
	public Pokedex() {
		ArrayList<Pokemon> mp = new ArrayList<Pokemon>();
		this.setMyPokemons(mp);
	}
	
	public ArrayList<Pokemon> getMyPokemons() {
		return myPokemons;
	}

	public void setMyPokemons(ArrayList<Pokemon> mp) {
		myPokemons = mp;
	}
	
	@Override
	public Pokemon createPokemon(String name, int health, String type) {
		// TODO Auto-generated method stub
		Pokemon p = new Pokemon(name, health, type);
		this.myPokemons.add(p);
		return p;
	}

	@Override
	public void listPokemon() {
		// TODO Auto-generated method stub
		for(Pokemon pokemon : this.myPokemons) {
			System.out.println(pokemonInfo(pokemon));
		}
	}

}
