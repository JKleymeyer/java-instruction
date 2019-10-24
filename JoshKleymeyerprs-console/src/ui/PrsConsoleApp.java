package ui;

import java.util.ArrayList;
import java.util.List;

import buisness.User;
import util.Console;

public class PrsConsoleApp {

	private static List<User> user = new ArrayList<>();

	public static void main(String[] args) {

		// add users
		User u1 = new User(1, "JKleymeyer", "password", "Josh", "Kleymeyer", 
				"8591231234", "fake@gmail.com", false, false);
		User u2 = new User(2, "SKleymeyer", "password!", "Sarah", "Kleymeyer", 
				"5131231234", "faker@gmail.com", true, false);
		User u3 = new User(3, "TKleymeyer", "password!!", "Ted", "Kleymeyer", 
				"8591121234", "fakest@gmail.com", true, true);

		// create ArrayList
		user.add(u1);
		user.add(u2);
		user.add(u3);

		System.out.println("PRS Console");

		String command = " ";
		//Start Loop
		while (!command.equals("6")) {
			command = Console.getString(getDisplayMethod());

			switch (command.toLowerCase()) {
			case "1":
				// list user
				for (int i = 0; i < user.size(); i++) {
					System.out.println((i + 1) + ". " + user.get(i));
				}
				break;
			case "2":
				// Get user
				User uName = getUserByUserName();
				System.out.println(uName);
				break;
			case "3":
				// add user
				User newUser = addUser();
				user.add(newUser);
				System.out.println("New user " + newUser + " has been added.");
				break;
			case "4":
				// edit a user
				User edit = getUserByUserName();
				String nEmail = Console.getString("New Email: ");
				edit.setEmail(nEmail);
				System.out.println(edit);
				break;
			case "5":
				// delete a user
				User u = getUserByUserName();
				user.remove(u);
				System.out.println(u + " was dropped");
				break;
			case "6":
				// exit
				break;
			default:
				System.out.println("Invalid command. Try again.");

			}
		}

		System.out.println("Goodbye!");

	}

	private static User addUser() {
		int id = user.size() + 1;
		String username = Console.getString("Enter Username: ");
		String password = Console.getString("Enter Password: ");
		String firstName = Console.getString("Enter First Name: ");
		String lastName = Console.getString("Enter Last Name: ");
		String phoneNumber = Console.getString("Enter Phone Number (without dashes): ");
		String email = Console.getString("Enter Email: ");

		// isReviewer validation
		boolean isReviewer = false;
		boolean isValid = false;
		while (!isValid) {
			String review = Console.getString("Is the user a reviewer? (y or n):");
			if (review.equalsIgnoreCase("y")) {
				isReviewer = !false;
				isValid = true;
			} else if (review.equalsIgnoreCase("n")) {
				isReviewer = false;
				isValid = true;
			} else {
				System.out.println("Invalid entry. Please enter Yes (Y) or No (N).");
			}
		}

		// isAdmin validation
		boolean isAdmin = false;
		boolean valid = false;
		while (!valid) {
			String admin = Console.getString("Is the user an admin? (y or n): ");
			if (admin.equalsIgnoreCase("y")) {
				isAdmin = !false;
				valid = true;
			} else if (admin.equalsIgnoreCase("n")) {
				isAdmin = false;
				valid = true;
			} else {
				System.out.println("Invalid entry. Please enter Yes (Y) or No (N).");
			}
		}
		User newUser = new User(id, username, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
		return newUser;
	}

	private static String getDisplayMethod() {
		String menu = "\nCOMMAND MENU \n" + "1 - List Users \n" + "2 - Get a User \n" + "3 - Add a User \n"
				+ "4 - Edit a User \n" + "5 - Delete a User\n" + "6 - Exit\n" + "\n" + "Command: ";
		return menu;
	}

	private static User getUserByUserName() {
		// Declare variables
		boolean found = false;
		boolean validName = false;
		String userName = "";

		while (!validName) {
			// Get user input and separate first/last name
			userName = Console.getString("Enter username: ");

			// Check for match and print user
			for (User user : user) {
				if (user.getUsername().equals(userName)) {
					found = true;
					return user;
				}
			}
		}
		if (!found) {
			System.out.println("No user found.\n");
		}
		return null;
	}
}
