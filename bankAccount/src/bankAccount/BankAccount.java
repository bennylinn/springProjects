package bankAccount;

import java.util.Random;

public class BankAccount {

	private String accountNumber;
	private double chequing;
	private double savings;
	private static int numberOfAcc = 0;
	private static double totalSavings = 0;
	private static double totalChequings = 0;
	
	public BankAccount(double c, double s) {
		this.setChequing(c);
		this.setSavings(s);
		this.setAccountNumber(random10());
		
		numberOfAcc += 1;
		// increment totalSavings
		totalSavings += s;
		// increment totalChequings
		totalChequings += c;
	}
	
	public static String random10() {
		String acc = "";
		Random rand = new Random();
		for (var i = 0; i < 10; i++) {
			int int_random = rand.nextInt(9);
			acc += Integer.toString(int_random);
		}
		
		return acc;
	}
	
	// deposit method; increment total; works for chequing or savings
	public void deposit(double amt, String account) {
		if (account == "savings") {			
			this.savings += amt;
			totalSavings += amt;
		} else if (account == "chequing") {
			this.chequing += amt;
			totalChequings += amt;
		} else {
			System.out.println("No account with this name");
		}
		
	}
	
	// withdraw method; decrement total; ""
	public void withdraw(double amt, String account) {
		if (account == "savings") {			
			if (this.savings >= amt) {
				this.savings -= amt;
				totalSavings -= amt;
			} else {
				System.out.println("Not enough money in Savings acc!");
			}
		} else if (account == "chequing") {
			if (this.chequing >= amt) {
				this.chequing -= amt;
				totalChequings -= amt;
			} else {
				System.out.println("Not enough money in Chequing acc!");
			}
		} else {
			System.out.println("No account with this name");
		}
	}
	
	// display method; see totals in chequings and savings
	public static void display() {
		System.out.println("There is $" + Double.toString(totalSavings) + " in Savings and $" + Double.toString(totalChequings) + " in Chequings.");
		System.out.println("There are " + Integer.toString(numberOfAcc) + " accounts in the system.");
	}
	//
	
	
	
	
	
	
	
	

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getChequing() {
		return chequing;
	}

	public void setChequing(double chequing) {
		this.chequing = chequing;
	}

	public double getSavings() {
		return savings;
	}

	public void setSavings(double savings) {
		this.savings = savings;
	}
	

}
