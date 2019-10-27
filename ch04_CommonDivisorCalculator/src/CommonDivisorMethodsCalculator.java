import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonDivisorMethodsCalculator {

	public static void main(String[] args) {
		// Welcome
		// Input First Number (y, needs to be larger)
		// Second Number(x, needs to be smaller)
		// Biz logic - Euclidean algorithm
		// if nested loop
		// Output Greatest Common Divisor

		// Add Scanner and choice Variable
		Scanner sc = new Scanner(System.in);
		String choice = "y";

		// Welcome
		System.out.println("Greatest Common Divisor Finder");
		System.out.println();

		while (choice.equalsIgnoreCase("y")) {
			int y = getInt("Enter first number: ", sc);
			int x = getInt("Enter second number: ", sc);
			// Repeat until x = 0
			while (x != 0) {
				// Subtract x from y repeatedly until y < x
				while (y >= x) {
					y -= x;
				}

				// Swap x and y
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

	private static int getInt(String prompt, Scanner scan) {
		boolean isValid = false;
		int i = 0;
		while (!isValid) {
			try {
			System.out.println(prompt);
			i = scan.nextInt();
			isValid = true;
		}
		catch (InputMismatchException ime) {
			System.out.println("Invalid Entry! Try Again.");
			scan.nextLine();
			continue;
			}
		}
		return i;
		
	}
}
