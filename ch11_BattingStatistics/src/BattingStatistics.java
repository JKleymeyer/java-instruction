import java.text.NumberFormat;

public class BattingStatistics {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Batting Average Calculator\n");

		// choice variable and start while loop
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			// Gather input
			int atBat = Console.getInt("Number of times at bat:\n", 0, 31);
			System.out.println("0 = out, 1 = single, 2 = double, 3 = triple, 4 = homerun");

			// Set array and gather data
			double[] bats = new double[atBat];
			for (int i = 0; i < bats.length; i++) {
				double result = Console.getDouble("Result for at-bat " + (i + 1) + ": ", -1, 5);
				bats[i] = result;
			}

			// Format to 3 decimal places
			NumberFormat number = NumberFormat.getNumberInstance();
			number.setMaximumFractionDigits(3);
			number.setMinimumFractionDigits(3);

			// find batting avg
			double batAvg = 0.0;
			double hits = 0.0;
			for (double ab : bats) {
				if (ab > 0) {
					ab = 1;
					hits += ab;
				}
			}
			batAvg = hits / atBat;
			System.out.println();
			System.out.println("Batting average: " + number.format(batAvg));

			// find slugging %
			double slugPct = 0.0;
			double sum = 0.0;
			for (double ab : bats) {
				if (ab > 0) {
					sum += ab;
				}
			}
			slugPct = sum / atBat;
			System.out.println("Slugging percent: " + number.format(slugPct));

			System.out.println();
			choice = Console.getString("Another Player? (y/n)");
			System.out.println();

		}
		System.out.println("Goodbye!");
	}
}
