
public class Pokemon {
	private String name;
	private int health;
	private String type;
	private static int count = 0;

	public Pokemon(String n, int h, String t) {
		this.setName(n);
		this.setHealth(h);
		this.setType(t);
		count++;
	}
	
	static void attackPokemon(Pokemon pokemon) {
		pokemon.health -= 10;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Pokemon.count = count;
	}

}
