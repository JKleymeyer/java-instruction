
public class ContactApp {

	public static void main(String[] args) {

		// Welcome
		System.out.println("Welcome to the Contact List application");

		String choice = "y";
		
		//Create loop
		while (choice.equalsIgnoreCase("y")){
			//Get inputs
			String firstName = Console.getString("Enter First Name: ");
			String lastName = Console.getString("Enter Last Name:  ");
			String email = Console.getString("Enter Email:      ");
			String phone = Console.getString("Enter Phone:      ");
			
			//create contact object
			Contact contact = new Contact(firstName, lastName, email, phone);
			
			//Display Output
			System.out.println();
			System.out.println(contact.displaycontact());

			
			//Continue?
			choice = Console.getString("Continue? (y/n): ");
            System.out.println();
			
		}
			System.out.println("Goodbye!");	
		}

}
