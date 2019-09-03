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

import java.util.ArrayList;

public class Product {
	
	private String name;
	private String type;
	private double price;
	private int quantity;
	private String inventoryCode;
	private ArrayList<String>ratings;
	
	public Product() {
		ratings = new ArrayList<>();
	}
	
	/*
	 * setName
	 *  @param name - new name for the product
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * getName
	 *  @return the name of the product
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * setType
	 *  @param type - the type of the product
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/*
	 * getType
	 * @return - the product type
	 */
	public String getType() {
		return type;
	}
	
	/*
	 * setPrice
	 * @param price - the price of the product
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/*
	 * getPrice
	 * @return the price of the product
	 */
	public double getPrice() {
		return price;
	}
	
	/*
	 * setQuantity
	 * @param quantity - the number of this product in inventory
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/*
	 * getQuantity
	 * @return the number of this product in inventory
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/*
	 * setInventoryCode
	 * @param code - the new inventory code for the product
	 */
	public void setInventoryCode(String code) {
		inventoryCode = code;
	}
	
	/*
	 * getInventoryCode
	 * @return the inventory code of the product
	 */
	public String getInventoryCode() {
		return inventoryCode;
	}
	
	/*
	 * addUserRating
	 * NOTE: Each individual rating is stored with the product, so you need to maintain a list
	 * of user ratings.  This method should append a new rating to the end of that list
	 * @param rating - the new rating to add to this product
	 */
	public void addUserRating(int rating) {
		//ratings = new ArrayList<>();
		String item = Integer.toString(rating);
		ratings.add(item);
	}
	
	/*
	 * getUserRating
	 * 	NOTE:  See note on addUserRating above.  This method should be written to allow you
	 * 	to access an individual value from the list of user ratings 
	 * @param index - the index of the rating we want to see
	 * @return the rating indexed by the value index
	 */
	public int getUserRating(int index) {
		int convert = Integer.parseInt(ratings.get(index));
		return convert;
	}
	
	/*
	 * getUserRatingCount
	 *  NOTE: See note on addUserRating above.  This method should be written to return
	 *  the total number of ratings this product has associated with it
	 * @return the number of ratings associated with this product
	 */
	public int getUserRatingCount() {
		return ratings.size();
	}
	
	/*
	 * getAvgUserRating
	 *  NOTE: see note on addUserRating above.  This method should be written to compute
	 *  the average user rating on demand from a stored list of ratings.
	 * @return the average rating for this product as a whole integer value (use integer math)
	 */
	public int getAvgUserRating() {
		ArrayList<Integer>convert = new ArrayList<>();
		int sum = 0;
		for(int i = 0;i<ratings.size();i++) {
			int changed = Integer.parseInt(ratings.get(i));
			convert.add(changed);
		}
		for(int i = 0; i<convert.size();i++) {
			sum = sum + convert.get(i);
		}
		
		if(convert.size()==0) {
			return 0;
		}
		else {
			return sum/convert.size();		}
	}
}
