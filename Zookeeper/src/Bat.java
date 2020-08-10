
public class Bat extends Mammal{
	
	public Bat(int e) {
		super(e);
	}
	
	public void fly() {
		System.out.println("Falp flap flap");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("monch Monch");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("Rawr xd");
		this.energyLevel -= 100;
	}
	
}
