
public class Gorilla extends Mammal {
	
	public Gorilla() {
		
	}
	
	public Gorilla(int e) {
		super(e);
	}
	
	public void throwSomething() {
		System.out.println("Throwing shit");
		this.energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("MMMmmmMMm banans");
		this.energyLevel += 10;
	}
	
	public void climb() {
		System.out.print("Euhg euerhg euhf !");
		this.energyLevel -= 10;
	}
}
