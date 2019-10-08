import java.util.Scanner;

public class GradeConverter {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Grade Converter");
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		//Create loop if they want to continue
		while (choice.equalsIgnoreCase("y")) {
			//Prompt Input
			System.out.print("Enter numeric grade: ");
			int numGrade = sc.nextInt();
			String letterGrade = "";
			
			//use grade criteria to convert numGrade to letterGrade
			if (numGrade >= 88)
				letterGrade = "A";
			else if (numGrade >= 80)
				letterGrade = "B";
			else if (numGrade >= 67)
				letterGrade = "C";
			else if (numGrade >= 60)
				letterGrade = "D";
			else
				letterGrade = "F";
			
			System.out.println("Letter grade: "+letterGrade);
			
			System.out.print("Continue?  ");
			choice = sc.next();
		}
        
			
        System.out.print("Goodbye!");
        sc.close();
	}

}
