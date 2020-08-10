
public interface OperateBicycle {
	// public, final, static
	// is called at the class level
	double myConstant = 3.0;
	
	// default method that does not need implementation
	// is called at the class level
	default void sayHello() {
		System.out.println("Hello from default");
	}
	
	// static method that does not need implementation
	// is called at the interface level
	static void staticMethod() {
		System.out.println("Hello from static");
	}
	
	
	// abstract methods that require implementation
	void speedUp(int increment);
	void speedDown(int decrement);
}
