/**
 * Product
 * 
 *   A simple class framework used to demonstrate the design
 *   of Java classes.
 *   
 *   @author Frank He
 *   @version 1/31/18
 */
package osu.cse2123;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project02 {

	public static void main(String[] args) {
		// Create new scanner then prompt for user input
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an inventory filename: ");
		String fileReport = in.nextLine();

		// Issue try and catch statement for the main method
		try {

			// Create new file
			File inputFile = new File(fileReport);
			Scanner input = new Scanner(inputFile);

			ArrayList<Product> summary = new ArrayList<>();

			// Use while loop to fill the array list
			while (input.hasNext()) {

				// Create new product object
				Product sample = new Product();
				sample.setName(input.nextLine());
				sample.setInventoryCode(input.nextLine());

				String quantity = input.nextLine();
				int quantityConvert = Integer.parseInt(quantity);
				sample.setQuantity(quantityConvert);

				String price = input.nextLine();
				double priceConvert = Double.parseDouble(price);
				sample.setPrice(priceConvert);

				sample.setType(input.nextLine());

				while (input.hasNext()) {
					String rating = input.nextLine();
					int ratingConvert = Integer.parseInt(rating);
					if (ratingConvert >= 0) {
						sample.addUserRating(ratingConvert);
					} else {
						break;
					}
				}

				// Add project object to the array list
				summary.add(sample);
			}

			// Print out summary report
			System.out.println("Product Inventory Summary Report");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println();
			System.out.printf("%-35s%-10s%-6s%7s%7s%7s%8s%n", "Product Name", "I Code", "Type", "Rating", "# Rat.",
					"Quant.", "Price");
			System.out.println("---------------------------------- " + "--------- " + "----  " + "------ " + " ------ "
					+ "------ " + "------- ");

			// Use for loop to get the values of each require variable
			for (int i = 0; i < summary.size(); i++) {

				String name = summary.get(i).getName();
				String code = summary.get(i).getInventoryCode();
				String type = summary.get(i).getType();
				int ratingCount = summary.get(i).getUserRatingCount();
				int averageRating = summary.get(i).getAvgUserRating();
				String stars = ratingStars(averageRating);
				int quantity = summary.get(i).getQuantity();
				double price = summary.get(i).getPrice();
				System.out.printf("%-35s%-10s%-6s%-7s%7d%7d%8.2f%n", name, code, type, stars, ratingCount, quantity,
						price);

			}

			// Print out summary
			System.out.println("--------------------------------------------------------------------------------");
			int totalAmount = totalProduct(summary);
			System.out.println("Total Products in database: " + totalAmount);

			// Get the highest and lowest rating items
			int highestAverage = maxAverageRating(summary);
			String highestStar = ratingStars(highestAverage);
			String highestItem = maxAverageIndex(summary);
			int lowestAverage = minAverageRating(summary);
			String lowestStar = ratingStars(lowestAverage);
			String lowestItem = minAverageRatingIndex(summary);

			System.out.println("Highest Average Ranked item: " + highestItem + " (" + highestStar + ")");
			System.out.println("Lowest Average Ranked item: " + lowestItem + " (" + lowestStar + ")");

			// Get the highest and lowest dollar items
			double highestCombo = maxDollar(summary);
			String maxItem = maxDollarItem(summary);
			double lowestCombo = minDollar(summary);
			String minItem = minDollarItem(summary);
			System.out.println("Highest Total Dollar item: " + maxItem + "($" + highestCombo + ")");
			System.out.println("Lowest Total Dollar item: " + minItem + "($" + lowestCombo + ")");

			System.out.println("--------------------------------------------------------------------------------");

			input.close();
		}

		// Use catch to catch any IO exceptions
		catch (IOException e) {
			System.out.println("ERROR");
		}
	}

	// Return the size of the array list
	private static int totalProduct(ArrayList<Product> total) {
		int sum = total.size();
		return sum;
	}

	// Return the max average rating of the array list
	private static int maxAverageRating(ArrayList<Product> total) {
		int max = total.get(0).getAvgUserRating();
		for (int i = 0; i < total.size(); i++) {
			if (total.get(i).getAvgUserRating() > max) {
				max = total.get(i).getAvgUserRating();
			}
		}
		return max;
	}

	// Return the min average rating of the array list
	private static int minAverageRating(ArrayList<Product> total) {
		int min = total.get(0).getAvgUserRating();
		for (int i = 0; i < total.size(); i++) {
			if (total.get(i).getAvgUserRating() < min) {
				min = total.get(i).getAvgUserRating();
			}
		}
		return min;
	}

	// Return the highest dollar amount of the array list
	private static double maxDollar(ArrayList<Product> total) {
		double max = total.get(0).getPrice() * total.get(0).getQuantity();
		for (int i = 0; i < total.size(); i++) {
			if (total.get(i).getPrice() * total.get(i).getQuantity() > max) {
				max = total.get(i).getPrice() * total.get(i).getQuantity();
			}
		}
		return max;
	}

	// //Return the lowest dollar amount of the array list
	private static double minDollar(ArrayList<Product> total) {
		double min = total.get(0).getPrice() * total.get(0).getQuantity();
		for (int i = 0; i < total.size(); i++) {
			if (total.get(i).getPrice() * total.get(i).getQuantity() < min) {
				min = total.get(i).getPrice() * total.get(i).getQuantity();
			}
		}
		return min;
	}

	// Return the max average item name of the array list
	private static String maxAverageIndex(ArrayList<Product> total) {
		int max = total.get(0).getAvgUserRating();
		int index = 0;
		for (int i = 0; i < total.size(); i++) {
			if (total.get(i).getAvgUserRating() > max) {
				max = total.get(i).getAvgUserRating();
				index = i;
			}
		}
		return total.get(index).getName();
	}

	// Return the min average item name of the array list
	private static String minAverageRatingIndex(ArrayList<Product> total) {
		int min = total.get(0).getAvgUserRating();
		int index = 0;
		for (int i = 0; i < total.size(); i++) {
			if (total.get(i).getAvgUserRating() < min) {
				min = total.get(i).getAvgUserRating();
				index = i;
			}
		}
		return total.get(index).getName();
	}

	// Return the max dollar item name of the array list
	private static String maxDollarItem(ArrayList<Product> total) {
		double max = total.get(0).getPrice() * total.get(0).getQuantity();
		int index = 0;
		for (int i = 0; i < total.size(); i++) {
			if (total.get(i).getPrice() * total.get(i).getQuantity() > max) {
				max = total.get(i).getPrice() * total.get(i).getQuantity();
				index = i;
			}
		}
		return total.get(index).getName();
	}

	// Return the min dollar item name of the array list
	private static String minDollarItem(ArrayList<Product> total) {
		double min = total.get(0).getPrice() * total.get(0).getQuantity();
		int index = 0;
		for (int i = 0; i < total.size(); i++) {
			if (total.get(i).getPrice() * total.get(i).getQuantity() < min) {
				min = total.get(i).getPrice() * total.get(i).getQuantity();
				index = i;
			}
		}
		return total.get(index).getName();
	}

	// Return a string that contains the amount of stars the item get from the
	// rating
	private static String ratingStars(int ratings) {
		String stars = "";
		for (int i = 0; i < ratings; i++) {
			stars = stars + "*";
		}
		return stars;
	}

}
