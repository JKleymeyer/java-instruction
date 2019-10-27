package ui;

import buisness.Customer;
import db.CustomerDB;
import db.NoSuchCustomerException;
import util.Console;

public class CustomerViewerApp {

	public static void main(String[] args) {
		
		//Welcome
		System.out.println("Customer Viewer");
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			int custNmbr = Console.getInt("\nEnter a customer number: ");
			Customer c;
			try {
				c = CustomerDB.getCustomer(custNmbr);
				System.out.println();
				System.out.println(c.getNameAndAddress()+"\n");
			} catch (NoSuchCustomerException e) {
				System.out.println(e.getMessage());;
			}
			
			
			
			choice = Console.getString("Display another customer? (y/n)");
		}
		
		System.out.println("\nGoodbye!");

	}

}
