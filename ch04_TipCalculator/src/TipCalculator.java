import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculator {

	public static void main(String[] args) {
		
		
		//Tip Calculator Application
		
		//Add Scanner and choice Variable
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		
		//Welcome
		System.out.println("Tip Calculator");
		System.out.println();
		
		while (choice.equalsIgnoreCase("y")) {
			
			//Collect Cost of Meal
			System.out.print("Cost of Meal: ");
			double meal = sc.nextDouble();
			System.out.println();
			
			//Number Formatting
			NumberFormat pf = NumberFormat.getPercentInstance();
			NumberFormat cf = NumberFormat.getCurrencyInstance();
			cf.setMaximumFractionDigits(2);
    		pf.setMaximumFractionDigits(2);
    		
    		for (double tip = .15; tip <= .25; tip +=.05) {
    			//Buisness Logic
    			double tAmount = meal * tip;
    			double fAmount = tAmount + meal;
    			//Display
    			System.out.println(pf.format(tip));
    			System.out.println("Tip Amount: " +cf.format(tAmount));
    			System.out.println("Total Amount: " +cf.format(fAmount));
    			System.out.println();

    			
    			
			}
			
    		System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
    		
		}
		
		System.out.println("Goodbye!");
		sc.close();
	}

}
