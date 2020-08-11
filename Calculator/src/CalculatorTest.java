
public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TI84 ti = new TI84();
		ti.setOperandOne(10.5);
		ti.setOperandTwo(5.2);
		ti.setOperation("+");
		ti.performOperations();
		System.out.println(ti.getResults());
	}

}
