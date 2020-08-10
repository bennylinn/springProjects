package bankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount ba1 = new BankAccount(200, 200);
		BankAccount ba2 = new BankAccount(200, 200);
		BankAccount ba3 = new BankAccount(200, 200);
		BankAccount.display();
		
		ba1.deposit(500, "chequing");
		BankAccount.display();
		
		ba1.withdraw(600, "chequing");
		ba1.withdraw(200, "chequing");
		ba1.withdraw(100, "chequing");
		BankAccount.display();
	}

}
