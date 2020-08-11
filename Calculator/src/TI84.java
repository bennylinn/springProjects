
public class TI84{
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double result;

	public void setOperandOne(double operand) {
		// TODO Auto-generated method stub
		this.operandOne = operand;
	}

	public void setOperation(String operation) {
		// TODO Auto-generated method stub
		this.operation = operation;
	}

	public void setOperandTwo(double operand) {
		// TODO Auto-generated method stub
		this.operandTwo = operand;
	}

	public void performOperations() {
		// TODO Auto-generated method stub
		if (this.operation == "+") {
			this.result = this.operandOne + this.operandTwo;
		} else if (this.operation == "-") {
			this.result = this.operandOne - this.operandTwo;
		} else if (this.operation == "*") {
			this.result = this.operandOne * this.operandTwo;
		} else if (this.operation == "/") {
			this.result = this.operandOne / this.operandTwo;
		} else {
			System.out.println("Invalid operation");
		}
	}

	public double getResults() {
		// TODO Auto-generated method stub
		return this.result;
	}
	
}
