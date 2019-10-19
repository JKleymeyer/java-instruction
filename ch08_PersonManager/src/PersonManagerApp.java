
public class PersonManagerApp {

	public static void main(String[] args) {

		//Welcome
		System.out.println("Welcome to the Person Manager\n");
		
		String choice = "y";
		//Start while loop
		while(choice.equalsIgnoreCase("y")) {
			
			//Generate Input (c/e)	
				String input = Console.getString("Create Customer or Employee? (c/e)");
				
			if (input.equalsIgnoreCase("c")) {
				String firstName = Console.getString("Enter First Name: ");
				String lastName = Console.getString("Enter Last Name:  ");
				String customerNumber = Console.getString("Customer Number: ");
				//Create Object
				Customer customer = new Customer(firstName, lastName, customerNumber);
				System.out.println();
				System.out.println(customer.toString());
				
			} else {
				String firstName = Console.getString("Enter First Name: ");
				String lastName = Console.getString("Enter Last Name:  ");
				String ssn = Console.getString("SSN: ");
				//Create Object
				Employee employee = new Employee(firstName, lastName, ssn);
				System.out.println();
				System.out.println(employee.toString());
			}
			System.out.println();
			choice = Console.getString("Continue? (y/n): ");
            System.out.println();
			
		}
		System.out.println("Goodbye!");

	}

}
