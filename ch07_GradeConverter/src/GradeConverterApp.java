
public class GradeConverterApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Letter Grade Converter\n");
		
		//set loop variable
		String choice = "y";
		
		//Start loop
		while (choice.equalsIgnoreCase("y")) {
			
			//create grade object
			Grade letterGrade = new Grade();
			
			
			letterGrade.setNumber(Console.getInt("Enter numerical grade:"));
			letterGrade.getNumber();
			System.out.println(letterGrade.getGrade());
			
			
			//Continue?
			choice = Console.getString("Continue? (y/n): ");
            System.out.println();
			
		}  System.out.println("Goodbye!");

	}

}
