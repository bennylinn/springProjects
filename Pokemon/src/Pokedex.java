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
	
	public void addPokemon(String name, int health, String type) {
		super.createPokemon(name, health, type);
	}

	@Override
	public void listPokemon() {
		// TODO Auto-generated method stub
		for(Pokemon pokemon : this.myPokemons) {
			System.out.println(pokemonInfo(pokemon));
		}
	}

}
