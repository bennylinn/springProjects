
public class TI84 implements Calculator {
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double result;
	
	@Override
	public void setOperandOne(double operand) {
		// TODO Auto-generated method stub
		this.operandOne = operand;
	}

	@Override
	public void setOperation(String operation) {
		// TODO Auto-generated method stub
		this.operation = operation;
	}

	@Override
	public void setOperandTwo(double operand) {
		// TODO Auto-generated method stub
		this.operandTwo = operand;
	}

	@Override
	public void performOperations() {
		// TODO Auto-generated method stub
		if (this.operation == "+") {
			this.result = this.operandOne + this.operandTwo;
		} else if (this.operation == "-") {
			this.result = this.operandOne - this.operandTwo;
		} else {
			System.out.println("Invalid operation");
		}
	}

	@Override
	public double getResults() {
		// TODO Auto-generated method stub
		return this.result;
	}
	
}
