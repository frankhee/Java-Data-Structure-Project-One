/*
 * @Author Frank He
 * @Version 1/17/18
 */
package osu.cse2123;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project01 {

	public static void main(String[] args) {

		// Create new scanner then prompt for user input
		Scanner in = new Scanner(System.in);
		System.out.print("Enter database filename: ");
		String fileReport = in.nextLine();

		// Issue try and catch statement for the main method
		try {

			// Create new file
			File inputFile = new File(fileReport);
			Scanner input = new Scanner(inputFile);

			// Create array lists for different elements in the file
			ArrayList<String> names = new ArrayList<>();
			ArrayList<String> quantity = new ArrayList<>();
			ArrayList<String> price = new ArrayList<>();
			ArrayList<String> type = new ArrayList<>();

			// Use while loop to fill the array lists
			while (input.hasNext()) {
				names.add(input.nextLine());
				quantity.add(input.nextLine());
				price.add(input.nextLine());
				type.add(input.nextLine());
			}

			// Print out report
			System.out.println("Product Summary Report");
			System.out.println("------------------------------------------------------------");
			for (int i = 0; i < type.size(); i++) {
				System.out.println("Title: " + names.get(i));
				System.out.println("        " + "Product Type: " + type.get(i));
				System.out.println("        " + "Price: " + price.get(i));
				System.out.println("        " + "Quantity: " + quantity.get(i));
				System.out.println();
			}

			// Determine the index of max and min quantity
			ArrayList<Integer> quantityConvert = convertInt(quantity);
			int maxQuantity = maxIndex(quantityConvert);
			int minQuantity = minIndex(quantityConvert);

			// Determine the index of max and min dollar
			ArrayList<Double> priceConvert = convertDouble(price);
			double maxDollar = maxDollar(quantityConvert, priceConvert);
			double minDollar = minDollar(quantityConvert, priceConvert);

			// Determine the max and min dollar amount
			ArrayList<Double> totalMoney = totalDouble(quantityConvert, priceConvert);
			int priceTotalMax = maxDollarIndex(totalMoney);
			int priceTotalMin = minDollarIndex(totalMoney);

			// Print out summary
			System.out.println("-----------------------------------------------------------------");
			System.out.println("Total products in database: " + names.size());
			System.out.println("Largest quantity item: " + names.get(maxQuantity) + " (" + type.get(maxQuantity) + ")");
			System.out.println("Highest total dollar item: " + names.get(priceTotalMax) + " ($" + maxDollar + ")");
			System.out
					.println("Smallest quantity item: " + names.get(minQuantity) + " (" + type.get(minQuantity) + ")");
			System.out.println("Lowest total dollar item: " + names.get(priceTotalMin) + " ($" + minDollar + ")");
			System.out.println("-----------------------------------------------------------------");
			
			input.close();
		}

		// Display ERROR message if file name is incorrect
		catch (IOException e) {
			System.out.println("ERROR");
		}

	}

	// Convert an array list of strings to an array list of integers
	private static ArrayList<Integer> convertInt(ArrayList<String> input) {
		ArrayList<Integer> digits = new ArrayList<>();
		for (int i = 0; i < input.size(); i++) {
			int change = Integer.parseInt(input.get(i));
			digits.add(change);
		}
		return digits;
	}

	// Convert an array list of strings to an array list of doubles
	private static ArrayList<Double> convertDouble(ArrayList<String> input) {
		ArrayList<Double> digits = new ArrayList<>();
		for (int i = 0; i < input.size(); i++) {
			double change = Double.parseDouble(input.get(i));
			digits.add(change);
		}
		return digits;
	}

	// Get the total dollar amount from quantity and price and store it in an array
	// list
	private static ArrayList<Double> totalDouble(ArrayList<Integer> quantity, ArrayList<Double> price) {
		ArrayList<Double> digits = new ArrayList<>();
		for (int i = 0; i < quantity.size(); i++) {
			double result = quantity.get(i) * price.get(i);
			digits.add(result);
		}
		return digits;
	}

	// Find the max value in an array list of integers
	private static int max(ArrayList<Integer> compare) {
		int max = 0;
		for (int i = 0; i < compare.size(); i++) {
			if (compare.get(i) > max) {
				max = compare.get(i);
			}
		}
		return max;
	}

	// Find the min value in an array list of integers
	private static int min(ArrayList<Integer> compare) {
		int min = 0;
		for (int i = 0; i < compare.size(); i++) {
			if (compare.get(i) < min) {
				min = compare.get(i);
			}
		}
		return min;
	}

	// Find the max value index in an array list
	private static int maxIndex(ArrayList<Integer> compare) {
		int max = compare.get(0);
		int maxIndex = 0;
		for (int i = 0; i < compare.size(); i++) {
			if (compare.get(i) > max) {
				max = compare.get(i);
			}
		}
		maxIndex = compare.indexOf(max);
		return maxIndex;
	}

	// Find the min value index in an array list
	private static int minIndex(ArrayList<Integer> compare) {
		int min = compare.get(0);
		int minIndex = 0;
		for (int i = 0; i < compare.size(); i++) {
			if (compare.get(i) < min) {
				min = compare.get(i);
			}
		}
		minIndex = compare.indexOf(min);
		return minIndex;
	}

	// Find the max value in an array list of doubles
	private static double maxDollar(ArrayList<Integer> quantity, ArrayList<Double> price) {
		double max = quantity.get(0) * price.get(0);
		for (int i = 0; i < quantity.size(); i++) {
			if ((quantity.get(i) * price.get(i) > max)) {
				max = ((quantity.get(i) * price.get(i)));
			}
		}
		return max;
	}

	// Find the min value in an array list of doubles
	private static double minDollar(ArrayList<Integer> quantity, ArrayList<Double> price) {
		double min = quantity.get(0) * price.get(0);
		for (int i = 0; i < quantity.size(); i++) {
			if ((quantity.get(i) * price.get(i) < min)) {
				min = ((quantity.get(i) * price.get(i)));
			}
		}
		return min;
	}

	// Find the max value index in an array list of doubles
	private static int maxDollarIndex(ArrayList<Double> price) {
		double max = price.get(0);
		int maxIndex = 0;
		for (int i = 0; i < price.size(); i++) {
			if ((price.get(i) > max)) {
				max = price.get(i);
			}
		}
		maxIndex = price.indexOf(max);
		return maxIndex;
	}

	// Find the min value index in an array list of doubles
	private static int minDollarIndex(ArrayList<Double> price) {
		double min = price.get(0);
		int minIndex = 0;
		for (int i = 0; i < price.size(); i++) {
			if ((price.get(i) < min)) {
				min = price.get(i);
			}
		}
		minIndex = price.indexOf(min);
		return minIndex;
	}
}
