import java.util.Scanner;

public class TableOfPowersApp {

	public static void main(String[] args) {
		
		// Welcome
		System.out.println("Welcome to the Squares and Cubes Table\n");
		
		//Add variables
		String choice = "y";
		Scanner sc = new Scanner(System.in);
		while (choice.equalsIgnoreCase("y")) {
			
			//Enter inputs
			System.out.print("Enter an integer: ");
			int integer = sc.nextInt();
			System.out.println();
			
			//Print out Display
			System.out.println("Number  Square  Cube \n"
					+ "======  ======  ======");
			
			//Create for loop
			for (int i = 1; i <= integer; i++) {
				
				//biz logic
				int square = i * i;
				int cube = i * i * i;
				
				//Print out biz logic
				System.out.println(+i +"       " 
						+square +"       " +cube);
			}

			System.out.println();
			System.out.print("Continue? (y/n)");
			choice = sc.next();
			System.out.println();
			
		}
		sc.close();
		System.out.println("Goodbye!");
	}

}
