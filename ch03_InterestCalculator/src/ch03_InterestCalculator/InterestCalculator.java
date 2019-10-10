package ch03_InterestCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculator {

	public static void main(String[] args) {
		// TODO Welcome
		//Input needed: Loan Amount and Interest Rate - Big Decimal
		//Buisness Logic
		//Calculate Interest
		//Goodbye
		//Include loop
		
		//Add Scanner and Choice Variable
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		//Welcome message
		System.out.println("Welcome to the Interest Calculator");
		System.out.println();
		
		//Start Loop
        while (choice.equalsIgnoreCase("y")) {
        	
        	System.out.print("Enter loan amount: ");
        	BigDecimal loan = sc.nextBigDecimal();
        
        	System.out.print("Enter interest rate: ");
        	BigDecimal rate = sc.nextBigDecimal();
        	System.out.println();
        	
        	
        	
        	//Format Loan and Rate
    		NumberFormat cf = NumberFormat.getCurrencyInstance();
    		NumberFormat pf = NumberFormat.getPercentInstance();
    		cf.setMaximumFractionDigits(2);
    		pf.setMaximumFractionDigits(4);
    		
    		//Output Formatted Loan and rate
    		System.out.println("Loan Amount: " +cf.format(loan));
    		System.out.println("Interest Rate: " +pf.format(rate));

    		//Calculate Interest Rate
    		BigDecimal interest = loan.divide(rate, 2, RoundingMode.HALF_UP);
    		System.out.println("Interest: " +pf.format(interest));
    		
        	
        	
        	
        	
        	
        	System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }

	}

}
