package ui;

import java.util.ArrayList;
import java.util.List;

import util.Console;

public class WizardInventoryApp {
	static List<String> items = new ArrayList<>();

	public static void main(String[] args) {
		// Welcome
		System.out.println("The Wizard Inventory Game\n");
		
		System.out.println("COMMAND MENU");
		System.out.println("show - Show an item\ngrab - Grab an item\nedit - Edit an item\n"
				+ "drop - Drop an Item\nexit - Exit Program\n");
		

		items.add("Wooden Staff");
		items.add("Wizard Hat");
		items.add("Cloth Shoes");
		
		String command = "";
		String item = " ";
		while ( !command.equalsIgnoreCase("exit")) {
			command = Console.getString("Command: ");
		
			if (command.equalsIgnoreCase("show")) {
				for (int i = 0; i < items.size(); i++) {
					System.out.println((i+1)+ ". " + items.get(i));
				}
				
			} else if (command.equalsIgnoreCase("drop")) {
				item = getItem(); 
				items.remove(item);
				System.out.println(item+ " was dropped");
				
			}else if (command.equalsIgnoreCase("grab")) {
				if (items.size()>3) {
					System.out.println("You can't add any more items. Drop one first");
				}else {
				item = (Console.getString("Name: "));
				items.add(item);
				System.out.println(item+ " was added");
				}
				
			}else if (command.equalsIgnoreCase("edit")) {
				item = getItem();
				String updItem = Console.getString("Updated Name: ");
				int idx = items.indexOf(item);
				items.set(idx, updItem);
				System.out.println("Item Number " + (idx+1) + " was updated");;
				
				
			}else items.clear();

		}
		System.out.println("Goodbye!");

	}
	
	private static String getItem() {
		int itemNbr = Console.getInt("Number: ", 0, items.size()+1);
		String str = items.get(itemNbr-1);
		return str;
	}

}
