package business;

public class SavingsAccount extends Account {

	double MonthlyInterestRate;
	double MonthlyInterestPayment;	
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(double balance, double monthlyInterestRate) {
		super(balance);
		MonthlyInterestRate = monthlyInterestRate;

	}

	public double getMonthlyInterestPayment() {
		return MonthlyInterestPayment;
	}

	public void setMonthlyInterestPayment(double monthlyInterestPayment) {
		MonthlyInterestPayment = monthlyInterestPayment;
	}
	
	public void applyPaymentToBalance () {
		// calculate interest payment
		MonthlyInterestPayment = balance * MonthlyInterestRate;
		//apply to balance
		balance += MonthlyInterestPayment;
		
	}
	
	
}
