package ui;

import java.util.List;

import buisness.Actor;
import buisness.Movie;
import db.ActorDB;
import db.MovieDB;
import util.Console;

public class BmdbApp {
	//create movie and actor db instance
	private static MovieDB movieDB = new MovieDB();
	private static ActorDB actorDB = new ActorDB();
	

	public static void main(String[] args) {
		System.out.println("BMDB Console App");
		int choice = 0;
		while (choice != 99) {
			choice = Console.getInt(getMenu(), 0, 100);
			switch (choice) {
			case 1:
				//list movie
				List<Movie> movies= MovieDB.list();
				System.out.println("\nList of Movies: ");
				for (Movie m : movies) {
					System.out.println(m);
				}
				break;
			case 2:
				//listActors
				List<Actor> actor = ActorDB.list();
				System.out.println("\nList of Actors: ");
				for (Actor a : actor) {
					System.out.println(a);
				}
				break;
			case 3:
				//add movie
				System.out.println("\nAdd a movie");
				String t = Console.getString("Title: ");
				String r = Console.getString("Rating: ");
				int y = Console.getInt("Year: ");
				String d = Console.getString("Director: ");
				//Create movie instance
				Movie m = new Movie(t,r,y,d);
				//Call addMovie method and add inputs
				int rc = movieDB.add(m);
				if (rc == 1) {
					System.out.println("Movie added successfully");
				} else {
					System.out.println("Error!");
				}
				
				break;
			case 4:
				//add Actor
				System.out.println("\nAdd an Actor");
				String f = Console.getString("First name: ");
				String l = Console.getString("Last Name: ");
				String g = Console.getString("Gender: ");
				String date = Console.getString("Birthday (YYYY-MM-DD): ");
				//Create movie instance
				Actor a = new Actor(f,l,g,date);
				//Call addMovie method and add inputs
				int rc2 = actorDB.add(a);
				if (rc2 == 1) {
					System.out.println("Movie added successfully");
				} else {
					System.out.println("Error!");
				}
				break;
			case 5:
				//update movie
				m = getMovie();
				if (m!=null) {
					int year = Console.getInt("New year: ");
					m.setYear(year);
					rc = movieDB.update(m);
					if (rc==1) {
						System.out.println("Movie update successful");
					} else {
						System.out.println("Error updating movie year.");
					}
				}
				else {
					System.out.println("Error....movie id doesn't exist.");
				}
				break;
			case 6:
				//update actor
				a = getActor();
				if (a!=null) {
					String name = Console.getString("New First name: ");
					a.setFirstName(name);
					rc2 = actorDB.update(a);
					if (rc2==1) {
						System.out.println("Movie update successful");
					} else {
						System.out.println("Error updating movie year.");
					}
				}
				else {
					System.out.println("Error....movie id doesn't exist.");
				}
				break;
			case 7:
				//delete movie
				m = getMovie();
				if (m!=null) {
					rc = movieDB.delete(m);
					if (rc==1) {
						System.out.println("Deleted successful");
					} else {
						System.out.println("Error deleting movie year.");
					}
				}
				else {
					System.out.println("Error....movie id doesn't exist.");
				}
				break;
			case 8:
				//delete actor
				a = getActor();
				if (a!=null) {
					rc = actorDB.delete(a);
					if (rc==1) {
						System.out.println("Deleted successful");
					} else {
						System.out.println("Error deleting actor.");
					}
				}
				else {
					System.out.println("Error....actor id doesn't exist.");
				}
				break;
			case 9:
				//get movie
				m = getMovie();
				if (m!=null) {
				System.out.println("Movie: ");
				System.out.println(m);
				} else {
					System.out.println("Error....movie id doesn't exist.");
				}
				break;
			case 10:
				//Get Actor
				a = getActor();
				if (a!=null) {
				System.out.println("Actor: ");
				System.out.println(a);
				} else {
					System.out.println("Error....actor id doesn't exist.");
				}
			case 99:
				break;
			default:
				System.out.println("Invalid command.");
				break;
			}
		}

		System.out.println("\nGoodbye!");

	}
	
	private static Movie getMovie() {
		int id = Console.getInt("Id: ", 0, Integer.MAX_VALUE);
		Movie m = movieDB.get(id);
		return m;
	}
	
	private static Actor getActor() {
		int id = Console.getInt("Id: ", 0, Integer.MAX_VALUE);
		Actor a = actorDB.get(id);
		return a;
	}
	
	private static String getMenu() {
	String menu = "\nMenu\n"
				 + "1 - List Movies\n"
				 + "2 - List Actors\n"
				 + "3 - Add Movie\n"
				 + "4 - Add Actor\n"
				 + "5 - Update Movie\n"
				 + "6 - Update Actor\n"
				 + "7 - Delete Movie\n"
				 + "8 - Delete Actor\n"
				 + "9 - Get Movie\n"
				 + "10 - Get Actor\n"
				 + "99- Exit\n"
				 + "Command:";
	return menu;
	}

}
