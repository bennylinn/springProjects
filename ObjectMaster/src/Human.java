
public class Human {
	int strength;
	int stealth;
	int intelligence;
	int health;
	
	public Human(int str, int ste, int iq) {
		this.setStrength(str);
		this.setStealth(ste);
		this.setIntelligence(iq);
		this.health = 100;
	}
	
	public Human() {
		this.setStrength(3);
		this.setStealth(3);
		this.setIntelligence(3);
		this.health = 100;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	public void attack(Human h) {
		System.out.println("Ouch bro");
		h.health -= this.strength;
	}
}
