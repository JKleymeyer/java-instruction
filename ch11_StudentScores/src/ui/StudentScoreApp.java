package ui;

import java.util.Arrays;

import buisness.Student;
import util.Console;

public class StudentScoreApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("The Student Scores Application\n");
		
		
		int nbrOfStudents = Console.getInt("Number of Students:\n", 0, 501);
		
		Student[] students = new Student[nbrOfStudents];
		for(int i = 0; i < nbrOfStudents; i++) {
			System.out.println("STUDENT " + (i+1));
			String ln = Console.getString("Last Name: ");
			String fn = Console.getString("First Name: ");
			int s = Console.getInt("Score: ", -1, 101);
			System.out.println();
			Student student = new Student(fn,ln,s);
			students[i] = student;
		}
		
		//biz logic
		Arrays.sort(students);
		
		System.out.println("SUMMARY");
		for ( Student s : students) {
			System.out.println(s);
		}
		
		
		System.out.println("Goodbye!");

	}

}
