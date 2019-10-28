package ui;

import java.util.List;

import buisness.Actor;
import buisness.Movie;
import db.ActorDB;
import db.MovieDB;
import util.Console;

public class BmdbApp {
	//create moviedb instance
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
			case 5:
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
			case 6:
				//get movie
				m = getMovie();
				if (m!=null) {
				System.out.println("Movie: ");
				System.out.println(m);
				} else {
					System.out.println("Error....movie id doesn't exist.");
				}
				break;
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
	
	private static String getMenu() {
	String menu = "\nMenu\n"
				 + "1 - List Movies\n"
				 + "2 - List Actors\n"
				 + "3 - Add Movie\n"
				 + "4 - Update Movie\n"
				 + "5 - Delete Movie\n"
				 + "6 - Get Movie\n"
				 + "99- Exit\n"
				 + "Command:";
	return menu;
	}

}
