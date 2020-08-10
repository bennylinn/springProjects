
public class BicycleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bicycle b = new Bicycle();
		System.out.println(Bicycle.myConstant);
		b.sayHello();
		Bicycle.callStaticMethodFromInterface();
		b.speedUp(6);
		b.speedDown(3);
		System.out.println(b.getSpeed());
	}

}
