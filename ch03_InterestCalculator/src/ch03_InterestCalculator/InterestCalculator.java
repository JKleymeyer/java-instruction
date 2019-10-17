package ch03_InterestCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculator {

	public static void main(String[] args) {
			
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
    		BigDecimal interest = loan.multiply(rate);
    		System.out.println("Interest: " +cf.format(interest));
    		
        	
        	
        	
        	
        	
        	System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }

	}

}
