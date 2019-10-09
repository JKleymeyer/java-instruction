package ch03_2_TravelTimeCalculator;

import java.util.Scanner;

public class TravelTimeCalculator {

	public static void main(String[] args) {
		/* Find Time Traveled from Miles and Miles Per Hour.
		 Use integer arithmetic and the division and modulus operators to get hours and
		 minutes. */
		
		//Welcome
		System.out.println("Welcome to the Time Traveled Calculator");
		System.out.println();
		
		//Define Variables
		Scanner sc = new Scanner(System.in);
		double miles;
		double mph;
		String choice = "y";
		
		//Start Loop
		while (choice.equalsIgnoreCase("y")) {
			
			//Collect inputs
			System.out.print("Enter miles: ");
			miles = sc.nextInt();
			System.out.print("Enter miles per hour: ");
			mph = sc.nextInt();
		
			//Print out Estimated travel time
		System.out.println();
		System.out.println("Estimate travel time\n"
				+ "--------------------");
		
		//Calculate travel time with a decimal
		double hours = miles/mph;
		
		//get number of minutes as an integer
		int minutes = (int) (hours * 60);
		
		//use integer arithmetic to get hours and minutes as integer
		int hoursInt = minutes / 60;
		minutes = minutes % 60;
		
		//Print out hours and minutes
		System.out.println("Hours:   "+ hoursInt);
		System.out.println("Minutes: "+ minutes);
		System.out.println();
		
		//Do they want to continue?
		System.out.print("Continue? (y/n): ");
		choice = sc.next();
		}//End Loop
		
		System.out.println("Goodbye!");
		sc.close();
	}

}
