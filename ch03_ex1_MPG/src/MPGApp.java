import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class MPGApp {

    public static void main(String[] args) {
    	/*Calculator to Calculate Miles Per Gallon from Miles driven and Gas Used
    	Use three different ways to format answer. Rounding, NumberFormat and BigDecimal
    	Currently set to use BigDecimal
    	*/
        System.out.println("Welcome to the Miles Per Gallon calculator");
        System.out.println();  // print a blank line
        
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        	
        
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter miles driven: ");
            //double miles = sc.nextDouble();
            BigDecimal miles = sc.nextBigDecimal();
            
            System.out.print("Enter gallons of gas used: ");
            //double gallons = sc.nextDouble();
            BigDecimal gallons = sc.nextBigDecimal();
            
            //Code for BigDecimal
            BigDecimal mpg = miles.divide(gallons, 2, RoundingMode.HALF_UP);
            System.out.println("Miles per gallon is " +mpg + ".");
            
            
            // double mpg = miles/gallons; //Variables used for Rounding and NumFormat
            /*Code for Rounding Method
            mpg = (double)Math.round(mpg*100)/100;
            System.out.println("Miles per gallon is " +mpg + ".");*/
            
            
            /*Code to Use for Number Format
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(2); //Set Number Format to 2 decimals
            Print out for Number Format
            System.out.println("Miles per gallon is " + nf.format(mpg) + ".");
            System.out.println(); */
            
            
            
            System.out.print("Calculate another MPG? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }
    
}
