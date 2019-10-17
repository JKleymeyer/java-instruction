import java.util.Scanner;

public class RectangleCalculator {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Area and Perimeter Calculator");
		System.out.println();
		
		//Declare variables
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		//Create while loop
		while(choice.equalsIgnoreCase("y")) {
			
			//gather inputs
			System.out.print("Enter Length: ");
			double length = sc.nextInt();
			System.out.print("Enter width: ");
			double width = sc.nextInt();
			
			//Biz logic
			double area = width * length;
			double perimeter = (2* width) + (2 * length);
			
			//Display outputs
			System.out.println("Area: " +area);
			System.out.println("Perimeter: " +perimeter);
			System.out.println();
			
			//Continue?
			System.out.print("Continue? (y/n)");
			choice = sc.next();
			System.out.println();
			
		}
		//End loop
		System.out.println("Goodbye!");
		sc.close();
		
	}

}
