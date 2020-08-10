
public class Bicycle implements OperateBicycle {
	private int speed;
	public Bicycle() {
		speed = 0;
	}
	
	// a static method that calls on the interface static method
	public static void callStaticMethodFromInterface() {
		OperateBicycle.staticMethod();
	}
	
	// implementing speed up
	@Override
	public void speedUp(int increment) {
		// TODO Auto-generated method stub
		speed += increment;
	}

	// implementing speed down
	@Override
	public void speedDown(int decrement) {
		// TODO Auto-generated method stub
		speed -= decrement;
	}
	
	public int getSpeed() {
		return speed;
	}

}
