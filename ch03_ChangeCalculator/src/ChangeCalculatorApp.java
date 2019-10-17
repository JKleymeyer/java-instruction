import java.util.Scanner;

public class ChangeCalculatorApp {

	public static void main(String[] args) {

		//Welcome
		System.out.println("Welcome to the Change Calculator");
		System.out.println();

		
		//Scanner and choice variable
		String choice = "y";
		Scanner sc = new Scanner(System.in);
		while (choice.equalsIgnoreCase("y")) {
			
			//Gather inputs
			System.out.println("Enter number of cents: ");
			int cents = sc.nextInt();
			
			//Biz logic
			int quarters = (cents / 25);
			int dimes = (cents - (quarters * 25)) / 10;
			int nickels = (cents - (quarters * 25) - (dimes * 10)) / 5;
			int pennies = (cents - (quarters * 25) - (dimes * 10) - (nickels * 5)) / 1;
			
			//Display outputs
			System.out.println("Quarters: " +quarters);
			System.out.println("Dimes: " +dimes);
			System.out.println("Nickels: " +nickels);
			System.out.println("Pennies: " +pennies);
		
		//Continue?	
		System.out.println("Continue? (y/n)");
		choice = sc.nextLine();
		System.out.println();
		sc.close();
			
		}
		//End loop
		System.out.println("Goodbye!");
		
	}
	
}
