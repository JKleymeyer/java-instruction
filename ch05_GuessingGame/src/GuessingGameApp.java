import java.util.Scanner;

public class GuessingGameApp {

	public static void main(String[] args) {
		// Welcome	
		System.out.println("Welcome to the Guess the Number Game");
		System.out.println("++++++++++++++++++++++++++++++++++++\n");
		
				
		//declare scanner
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			System.out.println("I'm thinking of a number from 1 to 100.\n" + 
					"Try to guess it.\n");
			int randNum = generateRandomNumber();
			int guessCount = 0;
			System.out.println("ndr = "+randNum);
			//Prompt for a quess, compare to randnum, display output
			//continue until guess == randnum
			int guess = 0;
			while (guess!=randNum) {
				guess = getIntWithinRange(sc, "Enter number", 0, 101);
				guessCount++;
				int diff = guess - randNum;
				String msg = "";
				if (diff <= -10) {
					msg = "Way too low!";
				}
				else if (diff<0) {;
				msg = "Too low!";
				}
				else if (diff>=10) {
					msg ="Way Too high";
				}
				else if (diff > 0) {
					msg = "Too high";
				}
				else {
					//Correct guess
					msg = "You got it in " + guessCount + " tries.";
					if (guessCount <= 3) {
						msg += "Great job!";
					}
					else if (guessCount <7) {
						msg += "Not Bad";
					}
					else {
						msg += "What took you so long?";
					}
				}
				System.out.println(msg);
			}
			
			choice = getString(sc, "Try again? (y/n): ");
			
		}

		sc.close();
		System.out.println("Goodbye!");

	}
	
	private static String getString(Scanner sc, String prompt) {
		String s = "";
		boolean isValid = false;
		//Keep prompting user until enters y or n
		while (!isValid) {
			System.out.println(prompt);
			s = sc.nextLine();
			//Check for empty string
			if (s.equalsIgnoreCase("")) {
				System.out.println("Error....entry is required");
				continue;
			}
			else if (s.equalsIgnoreCase("y")||s.equalsIgnoreCase("n")) {
				isValid = true;
			}
			else {
				System.out.println("Error....only 'y' or 'n' is accepted.");
				continue;
			}
		
		}
		return s;
	}
	
	
	public static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			i = getInt (sc, prompt);
			if (i <=min) {
				System.out.println("Error! Number must be greater than " + min + ".");
				}
			else if (i >=max) {
				System.out.println("Error! Number must be less that" + min + ".");
			}
			isValid = true;
		}
		return i;

	}
	
	public static int getInt (Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.println(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}
	
	private static int generateRandomNumber() {
		int r = (int) (Math.random() * 100)+1;
		return r;
		
	}

}
