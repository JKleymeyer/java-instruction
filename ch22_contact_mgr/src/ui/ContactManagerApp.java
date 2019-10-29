package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import buisness.Contact;
import buisness.TestContact;
import util.Console;

public class ContactManagerApp {

	public static void main(String[] args) {
		//Welcome
		System.out.println("Contact Manager App");
		
		int command = 0;
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
		contacts.add(new Contact("Ann Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));
		
		//Start while loop
		while (command!=99) {
			command = Console.getInt(getMenu(), 0, 100);
			switch (command) {
			case 1:
				//List contacts
				System.out.println("List all contacts: ");
				for (Contact c : contacts) {
					System.out.println(c);
				}
				break;
			case 2:
				//list contacts w/no phone number
				System.out.println("Contacts missing phone number:");
				List<Contact> contactsWithoutPhone = filterContactsWithoutPhoneNumbers(contacts);
				for (Contact c : contactsWithoutPhone) {
					System.out.println(c);
				}
				break;
			case 3:
				//list contacts w/no email
				System.out.println("Contacts missing email");
				List<Contact> contactsWithoutEmail = filterContactsWithoutEmails(contacts);
				for (Contact c : contactsWithoutEmail) {
					System.out.println(c);
				}
				break;
			case 4:
				//Lambda list: contacts w/no phone number
				System.out.println("Contacts missing phone number: ");
				contactsWithoutPhone = filterContacts(contacts, c -> c.getPhone() == null);
				for (Contact c : contactsWithoutPhone) {
					System.out.println(c); 
					}
				break;
			case 5:
				//Lambda list: contacts w/no email
				System.out.println("Contacts missing email: ");
				contactsWithoutEmail = filterContacts(contacts, c -> c.getEmail() == null);
				for (Contact c : contactsWithoutEmail) {
					System.out.println(c); 
					}
				break;
			case 6:
				//Lambda list: contacts named Mike Murach
				System.out.println("Contact named Mike Murach: ");
				List<Contact>  contactMike = filterContacts(contacts, c -> c.getName().equals("Mike Murach"));
				for (Contact c : contactMike) {
					System.out.println(c); 
					}
				break;
			case 7:
				//Lambda Predicate: No phone
				System.out.println("Lambda predicate for contact with no phone: ");
				contactsWithoutPhone = filterContactsPredicate(contacts, c -> c.getPhone()==null);
				for (Contact c : contactsWithoutPhone) {
					System.out.println(c); 
					}
				break;
			case 8:
				System.out.println("Lambda: Predicate: Print names ");
				processContacts(contacts, c -> System.out.println(c.getName()));
				break;
			case 9:
				System.out.println("Streams - List names for each contact missing phone");
				contacts.stream().filter(c-> c.getPhone()==null)
								 .forEach(c-> System.out.println(c.getName()));
				break;
			case 10:
				System.out.println("Map and reduce: ");
				String csv = contacts.stream().map(c-> c.getName()).reduce(" ", (a,b) -> a + b + ", ");
				csv = csv.substring(0, csv.length() - 2);
				System.out.println("All Contacts: " +csv);
			case 99:
				//exit
				break;
			default:
				System.out.println("Invalid command! Choose 1-8 or 99");
				break;
			}
		}
		
		System.out.println("Goodbye!");

	}

	private static String getMenu() {
	String menu = "\nMenu\n"
				 + "1 -  List contacts\n"
				 + "2 -  List contacts with no phone number\n"
				 + "3 -  List contacts with no email\n"
				 + "4 -  Lambda: List contacts with no email\n"
				 + "5 -  Lambda: List contacts with no phone number\n"
				 + "6 -  Lambda: Names with mike Murach\n"
				 + "7 -  Lambda predicate no phone\n"
				 + "8 -  Lambda Consumer Print Names\n"
				 + "9 -  Stream w/no email\n"
				 + "10 - Map and reduce names to single stream\n"
				 + "99 - Exit\n"
				 + "Command:";
	return menu;
	}
	
	public static List<Contact> filterContactsWithoutPhoneNumbers(List<Contact> contacts) {
		
		List<Contact> contactsWithoutPhone = new ArrayList<>();
		for(Contact c : contacts) {
			if (c.getPhone()==null) {
				System.out.println(contactsWithoutPhone.add(c));
			}
		}
		return contactsWithoutPhone;
	}
	
	public static List<Contact> filterContactsWithoutEmails(List<Contact> contacts) {
		
		List<Contact> contactsWithoutEmail = new ArrayList<>();
		for(Contact c : contacts) {
			if (c.getEmail()==null) {
				System.out.println(contactsWithoutEmail.add(c));
			}
		}
		return contactsWithoutEmail;
	}
	
	//make one method that can replace the above 2 methods
	//pg 705
	public static List<Contact> filterContacts(List<Contact> contacts, TestContact condition) {
		List<Contact> filterContacts = new ArrayList<>();
		for(Contact c : contacts) {
			if (condition.test(c)) {
				filterContacts.add(c);
			}
		}
		return filterContacts;
	}

	public static List<Contact> filterContactsPredicate(List<Contact> contacts, Predicate<Contact>condition) {
		List<Contact> filterContacts = new ArrayList<>();
		for(Contact c : contacts) {
			if (condition.test(c)) {
				filterContacts.add(c);
			}
		}
		return filterContacts;
	}

	public static void processContacts(List<Contact> contacts, Consumer<Contact> consumer) {
		for (Contact c: contacts ) {
			consumer.accept(c);
		}
	}
	
}
