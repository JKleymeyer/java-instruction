package ch03_1_TemperatureConverter;

import java.util.Scanner;

public class TemperatureConverter {

	public static void main(String[] args) {
		
		//Temperature Converter app going from Fahrenheit to Celcius

		//Welcome Statement
		System.out.println("Welcome to the Temperature Converter");
		System.out.println();
		
		//Add Variables
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		//Begin Loop
		while (choice.equalsIgnoreCase("y")) {
			
			//Prompt Inputs
			System.out.print("Enter Degrees in Fahrenheit: ");
			double fDegrees = sc.nextDouble();

			//Buisness logic to convert to Celcius
			double cDegrees = ((fDegrees - 32) * 5)/9;
			cDegrees = (double)Math.round(cDegrees*100)/100;
			
			//Output
			System.out.println("Degrees in Celsius: " +cDegrees);
			
			
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			
		} //End Loop

		System.out.println("Goodbye!");
	
	sc.close();	
	}

}
