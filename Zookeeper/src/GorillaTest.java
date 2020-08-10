
public class GorillaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla gorilla = new Gorilla(1000);
		System.out.println(gorilla.getEnergyLevel());
		
		gorilla.throwSomething();
		gorilla.throwSomething();
		gorilla.throwSomething();
		gorilla.eatBananas();
		gorilla.eatBananas();
		gorilla.climb();
		
		System.out.println(gorilla.getEnergyLevel());
	}

}
