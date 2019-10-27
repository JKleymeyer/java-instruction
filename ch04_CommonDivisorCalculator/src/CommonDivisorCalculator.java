import java.util.Scanner;

public class CommonDivisorCalculator {

	public static void main(String[] args) {
		// Welcome
		// Input First Number (y, needs to be larger)
			   //Second Number(x, needs to be smaller)
		// Biz logic - Euclidean algorithm
		// if nested loop
		//Output Greatest Common Divisor
		
		//Add Scanner and choice Variable
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		
		//Welcome
		System.out.println("Greatest Common Divisor Finder");
		System.out.println();
		
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter first number: ");
			int y = sc.nextInt();
			
			System.out.print("Enter second number: ");
			int x = sc.nextInt();
		
		//Repeat until x = 0
		while (x != 0) {
			//Subtract x from y repeatedly until y < x
			while (y >= x) {
				y-=x;
			}
			
			//Swap x and y
			int temp = x;
			x = y;
			y = temp;
			
			
		}
			
			
		System.out.println("Greatest Common Divisor is " + y);	
		System.out.println();
		System.out.print("Continue? (y/n): ");
		choice = sc.next();
		System.out.println();	
		}
		
		
		
				
		System.out.println("Goodbye!");
		sc.close();
	}

}
