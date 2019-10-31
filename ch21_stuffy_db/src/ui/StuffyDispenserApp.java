package ui;

import java.util.List;

import buisness.Stuffy;
import db.StuffyDB;
import util.Console;

public class StuffyDispenserApp {
	private static StuffyDB stuffyDB = new StuffyDB();

	public static void main(String[] args) {
		System.out.println("Welcome to the Stuffy Dispenser App");
		int command = 0;
		while (command != 6) {
			command = Console.getInt(getMenu(), 0, 7);
			switch (command) {
				case 1:
					//List
					List<Stuffy> stuffy = StuffyDB.getAll();
					System.out.println("\nList of Stuffy: ");
					for (Stuffy s : stuffy) {
						System.out.println(s);
					}
					break;
				case 2:
					//get
					int id = Console.getInt("Id: ");
					Stuffy s = getStuffy(id);
					if (s!=null) {
						System.out.println("Actor: ");
						System.out.println(s);
						} else {
							System.out.println("Error....stuffy id doesn't exist.");
						}
					break;
				case 3:
					//add - prompt user for stuffy values
					System.out.println("\nAdd a stuffy");
					String type = Console.getString("Type: ");
					String color = Console.getString("Color: ");
					String size = Console.getString("Size: ");
					int limbs = Console.getInt("Limbs: ");
					//Create movie instance
					s = new Stuffy(type,color,size,limbs);
					//Call addMovie method and add inputs
					int rc = stuffyDB.add(s);
					if (rc == 1) {
						System.out.println("Movie added successfully");
					} else {
						System.out.println("Error!");
					}
					break;
				case 4:
					//edit
					id = Console.getInt("Id:");
					s = getStuffy(id);
					if (s!=null) {
						type = Console.getString("New type: ");
						s.setType(type);
						rc = stuffyDB.update(s);
						if (rc==1) {
							System.out.println("Stuffy update successful");
						} else {
							System.out.println("Error updating Stuffy type.");
						}
					}
					else {
						System.out.println("Error....stuffy id doesn't exist.");
					}
					break;
				case 5:
					//delete
					id = Console.getInt("Id: ");
					s = getStuffy(id);
					if (s!=null) {
						rc = stuffyDB.delete(s);
						if (rc==1) {
							System.out.println("Deleted successful");
						} else {
							System.out.println("Error deleting stuffy year.");
						}
					}
					else {
						System.out.println("Error....stuffy id doesn't exist.");
					}
					break;
				case 6:
					//exit
					break;
				default:
					//error
					System.out.println("Invalid command! Choose 1-6");
			}

		}
		
		System.out.println("Goodbye");

	}

	private static Stuffy getStuffy(int id) {
		Stuffy s = stuffyDB.get(id);
		if (s!=null) {
			System.out.println(s);
		} 
		else{
			System.out.println("No user exists for id " +id);
		}
		return s;
	}
	
	private static String getMenu() {
	String menu = "\nMenu\n"
				 + "1 - List\n"
				 + "2 - Get\n"
				 + "3 - Add\n"
				 + "4 - Edit\n"
				 + "5 - Delete\n"
				 + "6 - Exit\n"
				 + "Command:";
	return menu;
	}
	
}
