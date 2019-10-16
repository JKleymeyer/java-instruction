package ui;

import java.text.NumberFormat;

import business.Account;
import business.CheckingAccount;
import business.SavingsAccount;
import util.Console;

public class AccountBalanceApp {
		static NumberFormat cf = NumberFormat.getCurrencyInstance();

	public static void main(String[] args) {
		
		//Welcome
		System.out.println("Welcome to the Account application");
		System.out.println();
		
		//Create checking account adding the initial balance and the fee
		CheckingAccount ca = new CheckingAccount( 1000, 1);
		//Create Savings Account adding initial balance and fee
		SavingsAccount sa = new SavingsAccount ( 1000, .01 );
		
		System.out.println("Starting Balances");
		//Method to display starting balances
		displayBalances(ca, sa);
		System.out.println();
		System.out.println("Enter Transactions for the Month");
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String transaction = Console.getString("Withdraw or Deposit? (w/d)");
			String account = Console.getString("Checking or Savings? (c/s)");
			double amount = Console.getDouble("Amount?", 0 , Double.POSITIVE_INFINITY); // PI makes sure we don't use a negative
			
			//add inputs
			Account a = null;
			if (account.equalsIgnoreCase("c")) {
				a = ca;
			} else if (account.equalsIgnoreCase("s")) {
				a = sa;
			} else {
				System.out.println("Invalid account type");
				continue;
			}
			
			if (transaction.equalsIgnoreCase("w")) {
				a.withdraw(amount);
			} else if (transaction.equalsIgnoreCase("d")) {
				a.deposit(amount);
			} else {
				System.out.println("Invalid transaction");
				continue;
			}
	
			
		choice = Console.getString("Continue? (y/n)");
			
		}
		
		//apply monthly fee/balance
		ca.subtractMonthlyFeeFromBalance();
		sa.applyPaymentToBalance();
		
		System.out.println();
		System.out.println("Monthly Payments and Fees");
		System.out.println("Checking Fee "+ cf.format(ca.getMonthlyFee()));
		System.out.println("Savings Interest Payment " + cf.format(sa.getMonthlyInterestPayment()));
		System.out.println();
		System.out.println("Final Balances: ");
		displayBalances(ca, sa);
		
		System.out.println();
		System.out.println("Goodbye!");
	}
	
	
	//Create a method to display account balances
	private static void displayBalances(CheckingAccount ca, SavingsAccount sa) {
		System.out.println("Checking: "+cf.format(ca.getBalance()));
		System.out.println("Savings: "+cf.format(sa.getBalance()));
		
		}

}
