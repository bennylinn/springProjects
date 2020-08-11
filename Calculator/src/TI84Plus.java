import java.util.*;

public class TI84Plus implements Calculator {
	private double result = 0.0;
	private double nextOperand;
	private String incrementalOperation;
	private String multiplicativeOperation;
	
	@Override
	public void performOperations(double num) {
		// TODO Auto-generated method stub
		if (IsNullOrEmpty(this.getResults())) {
			this.setResults(num);
		} else {
			this.setNextOperand(num);
		}
	}
	
	
	@Override
	public void performOperations(String operation) {
		if (operation == "+" || operation == "-") {
			if (IsNullOrEmpty(this.getIncrementalOperation())) {
				this.setIncrementalOperation(operation);
			} else {
				if (operation == "+") {
					this.setResults(this.getResults() + this.getNextOperand());
					this.setIncrementalOperation(operation);
				} else if (operation == "-") {
					this.setResults(this.getResults() - this.getNextOperand());
					this.setIncrementalOperation(operation);
				}
			}
		} else if (operation == "*" || operation == "/") {
			if (IsNullOrEmpty(this.getMultiplicativeOperation())) {
				if (this.getMultiplicativeOperation() == "*" && (this.getIncrementalOperation() == "+" || this.getIncrementalOperation() == "-")) {
					if (this.getMultiplicativeOperation() == "*" || this.getMultiplicativeOperation() == "/") {
						this.setNextOperand(this.getNextOperand()*);
					}
				}
			}
		}
	}
	
	private static Boolean IsNullOrEmpty(Object obj) {
		if (obj == null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
	public double getNextOperand() {
		return nextOperand;
	}

	public void setNextOperand(double nextOperand) {
		this.nextOperand = nextOperand;
	}

	public String getIncrementalOperation() {
		return incrementalOperation;
	}

	public void setIncrementalOperation(String incrementalOperation) {
		this.incrementalOperation = incrementalOperation;
	}

	public String getMultiplicativeOperation() {
		return multiplicativeOperation;
	}

	public void setMultiplicativeOperation(String multiplicativeOperation) {
		this.multiplicativeOperation = multiplicativeOperation;
	}


	@Override
	public double getResults() {
		// TODO Auto-generated method stub
		return this.result;
	}
	
	public void setResults(double result) {
		this.result = result;
	}
	
	

}
